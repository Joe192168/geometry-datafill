package com.geometry.pojo.utils;

import lombok.extern.log4j.Log4j2;

/**
 * @Program: geometry-bi
 * @Description: TODO SQL构造器
 * @Author: xiaoqiaohui
 * @Create: 2019/11/8 18:54
 * @Version: 1.0.0
 */
@Log4j2
public class SQLConstructorUtils {

    /**
     * 数据库类型
     */
    private enum TYPE {
        ORACLE("oracle"),
        MYSQL("mysql"),
        SQLSERVER("sqlserver"),
        DB2("db2"),
        POSTGRESQL("postgresql");

        private String typeName;

        TYPE(String typeName) {
            this.typeName = typeName;
        }

        /**
         * 根据类型的名称，返回类型的枚举实例。
         *
         * @param typeName 类型名称
         */
        public static TYPE fromTypeName(String typeName) {
            for (TYPE type : TYPE.values()) {
                if (type.getTypeName().equals(typeName)) {
                    return type;
                }
            }
            return null;
        }

        public String getTypeName() {
            return this.typeName;
        }
    }

    /**
     * 获取分页的SQL语句
     * @param _sql 基础语句
     * @param pageNum 每页记录数
     * @param pageSize 页数
     * @return 返回设定好分页的SQL语句
     * @throws Exception
     */
    public static String getSqlLimit(String _sql, int pageNum, int pageSize,String dbType) throws Exception {
        TYPE type = TYPE.fromTypeName(dbType.toLowerCase().trim());

        /**
         * #############Oracle分页方式###############
         */
        if(type == TYPE.ORACLE) {
            _sql = _sql.trim();
            StringBuffer pagingSelect = new StringBuffer(_sql.length()+100 );
            pagingSelect.append("select * from ( select t.*,rownum row_ from ( ");
            pagingSelect.append(_sql);
            pagingSelect.append(" ) t where rownum<= " + (pageNum + 1)*pageSize + ") where row_> " + pageSize);
            //结束
            if(log.isDebugEnabled()) {
                log.debug(">>SQLConstructorUtils-end(oracle):" + pagingSelect.toString());
            }
            return pagingSelect.toString();
        }
        //使用的是mysql的分页方式
        else if(type == TYPE.MYSQL) {
            String result = new StringBuffer(_sql.length()+20 )
                    .append(_sql)
                    .append(" limit " + (pageNum-1)*pageSize + ", " + pageSize )
                    .toString();
            //结束
            if(log.isDebugEnabled()) {
                log.debug(">>SQLConstructorUtils-end(mysql):" + result);
            }
            return result;
        }
        /**
         * ############## SQLServer分页方式 ################
         */
        else if(type == TYPE.SQLSERVER) {
            StringBuffer pagingBuilder = new StringBuffer();
            String orderby = getOrderByPart(_sql);
            String distinctStr = "";

            String loweredString = _sql.toLowerCase();
            String sqlPartString = _sql.trim();
            if (loweredString.trim().startsWith("select")) {
                int index = 6;
                if (loweredString.startsWith("select distinct")) {
                    distinctStr = "DISTINCT ";
                    index = 15;
                }
                sqlPartString = sqlPartString.substring(index);
            }
            pagingBuilder.append(sqlPartString);
            // if no ORDER BY is specified use fake ORDER BY field to avoid errors
            if (orderby == null || orderby.length() == 0) {
                orderby = "ORDER BY CURRENT_TIMESTAMP";
            }
            StringBuffer result = new StringBuffer();
            result.append("SELECT * FROM (")
                    .append("SELECT ")
                    .append(distinctStr)
                    .append(" TOP 100 PERCENT ROW_NUMBER() OVER (") //使用TOP 100 PERCENT可以提高性能
                    .append(orderby)
                    .append(") AS __hibernate_row_nr__, ")
                    .append(pagingBuilder)
                    .append(") as ucstarTempTable WHERE __hibernate_row_nr__ >")
                    .append(pageNum)
                    .append(" AND __hibernate_row_nr__ <=")
                    .append(pageNum + pageSize)
                    .append(" ORDER BY __hibernate_row_nr__");

            //结束
            if(log.isDebugEnabled()) {
                log.debug(">>SQLConstructorUtils-end(sqlserver):" + result.toString());
            }
            return result.toString();
        }
        //IBM的DB2的分页方式
        else if(type == TYPE.DB2) {
            StringBuffer result = new StringBuffer();
            result.append("SELECT * FROM ( ")
                    .append(" SELECT B.*, ROWNUMBER() OVER() AS RN FROM ( ")
                    .append(_sql)
                    .append(" ) AS B ")
                    .append(" )AS A WHERE A.RN BETWEEN "+(pageNum-1)*pageSize+" AND "+pageSize+"");
            //结束
            if(log.isDebugEnabled()) {
                log.debug(">>SQLConstructorUtils-end(db2):" + result);
            }
            return result.toString();
        }
        //使用的是postgresql的分页方式
        else if(type == TYPE.POSTGRESQL) {
            String result = new StringBuffer(_sql.length()+20 )
                    .append(_sql)
                    .append(" limit " + pageSize + " offset " + (pageNum-1)*pageSize )
                    .toString();
            //结束
            if(log.isDebugEnabled()) {
                log.debug(">>SQLConstructorUtils-end(postgresql):" + result);
            }
            return result;
        }
        /**
         * ############# 不支持的分页 ##############
         */
        else {
            log.error("No support Paging!");
            return _sql;
        }
    }

    /**
     * SQLServer的处理
     * @param sql
     * @return
     */
    static String getOrderByPart(String sql) {
        String loweredString = sql.toLowerCase();
        int orderByIndex = loweredString.indexOf("order by");
        if (orderByIndex != -1) {
            // if we find a new "order by" then we need to ignore
            // the previous one since it was probably used for a subquery
            return sql.substring(orderByIndex);
        } else {
            return "";
        }
    }

}
