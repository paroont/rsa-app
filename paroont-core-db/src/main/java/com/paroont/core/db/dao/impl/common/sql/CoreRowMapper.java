package com.paroont.core.db.dao.impl.common.sql;

import com.paroont.core.db.constant.common.CoreDbConst;
import com.paroont.core.db.dao.entity.common.CoreBaseDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class CoreRowMapper<T extends CoreBaseDo> implements RowMapper<T>, CoreDbConst {


    protected void mapCreatedData(T data, ResultSet rs) throws SQLException {
        data.setCreatedBy(rs.getString(DB_COMMON_COLUMN_CREATED_BY));
        data.setCreatedTs(rs.getTimestamp(DB_COMMON_COLUMN_CREATED_TS));
    }

    protected void mapStatusData(T data, ResultSet rs) throws SQLException {
        data.setStatusId(rs.getInt(DB_COMMON_COLUMN_STATUS_ID));
        data.setStatusTitle(rs.getString(DB_COMMON_COLUMN_STATUS_TITLE));
    }

    protected void mapUpdatedData(T data, ResultSet rs) throws SQLException {
        data.setUpdatedBy(rs.getString(DB_COMMON_COLUMN_UPDATED_BY));
        data.setUpdatedTs(rs.getTimestamp(DB_COMMON_COLUMN_UPDATED_TS));
    }

    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        T data = createData();
        mapData(data, rs, rowNum);
        return data;
    }

    protected abstract T createData();

    protected abstract void mapData(T data, ResultSet rs, int rowNum) throws SQLException;

}
