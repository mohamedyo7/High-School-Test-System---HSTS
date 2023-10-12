package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$schema_index_statistics", schema = "sys", catalog = "")
public class X$SchemaIndexStatisticsEntity {
    @Basic
    @Column(name = "table_schema")
    private String tableSchema;
    @Basic
    @Column(name = "table_name")
    private String tableName;
    @Basic
    @Column(name = "index_name")
    private String indexName;
    @Basic
    @Column(name = "rows_selected")
    private Object rowsSelected;
    @Basic
    @Column(name = "select_latency")
    private Object selectLatency;
    @Basic
    @Column(name = "rows_inserted")
    private Object rowsInserted;
    @Basic
    @Column(name = "insert_latency")
    private Object insertLatency;
    @Basic
    @Column(name = "rows_updated")
    private Object rowsUpdated;
    @Basic
    @Column(name = "update_latency")
    private Object updateLatency;
    @Basic
    @Column(name = "rows_deleted")
    private Object rowsDeleted;
    @Basic
    @Column(name = "delete_latency")
    private Object deleteLatency;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Object getRowsSelected() {
        return rowsSelected;
    }

    public void setRowsSelected(Object rowsSelected) {
        this.rowsSelected = rowsSelected;
    }

    public Object getSelectLatency() {
        return selectLatency;
    }

    public void setSelectLatency(Object selectLatency) {
        this.selectLatency = selectLatency;
    }

    public Object getRowsInserted() {
        return rowsInserted;
    }

    public void setRowsInserted(Object rowsInserted) {
        this.rowsInserted = rowsInserted;
    }

    public Object getInsertLatency() {
        return insertLatency;
    }

    public void setInsertLatency(Object insertLatency) {
        this.insertLatency = insertLatency;
    }

    public Object getRowsUpdated() {
        return rowsUpdated;
    }

    public void setRowsUpdated(Object rowsUpdated) {
        this.rowsUpdated = rowsUpdated;
    }

    public Object getUpdateLatency() {
        return updateLatency;
    }

    public void setUpdateLatency(Object updateLatency) {
        this.updateLatency = updateLatency;
    }

    public Object getRowsDeleted() {
        return rowsDeleted;
    }

    public void setRowsDeleted(Object rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }

    public Object getDeleteLatency() {
        return deleteLatency;
    }

    public void setDeleteLatency(Object deleteLatency) {
        this.deleteLatency = deleteLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$SchemaIndexStatisticsEntity that = (X$SchemaIndexStatisticsEntity) o;

        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (indexName != null ? !indexName.equals(that.indexName) : that.indexName != null) return false;
        if (rowsSelected != null ? !rowsSelected.equals(that.rowsSelected) : that.rowsSelected != null) return false;
        if (selectLatency != null ? !selectLatency.equals(that.selectLatency) : that.selectLatency != null)
            return false;
        if (rowsInserted != null ? !rowsInserted.equals(that.rowsInserted) : that.rowsInserted != null) return false;
        if (insertLatency != null ? !insertLatency.equals(that.insertLatency) : that.insertLatency != null)
            return false;
        if (rowsUpdated != null ? !rowsUpdated.equals(that.rowsUpdated) : that.rowsUpdated != null) return false;
        if (updateLatency != null ? !updateLatency.equals(that.updateLatency) : that.updateLatency != null)
            return false;
        if (rowsDeleted != null ? !rowsDeleted.equals(that.rowsDeleted) : that.rowsDeleted != null) return false;
        if (deleteLatency != null ? !deleteLatency.equals(that.deleteLatency) : that.deleteLatency != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (indexName != null ? indexName.hashCode() : 0);
        result = 31 * result + (rowsSelected != null ? rowsSelected.hashCode() : 0);
        result = 31 * result + (selectLatency != null ? selectLatency.hashCode() : 0);
        result = 31 * result + (rowsInserted != null ? rowsInserted.hashCode() : 0);
        result = 31 * result + (insertLatency != null ? insertLatency.hashCode() : 0);
        result = 31 * result + (rowsUpdated != null ? rowsUpdated.hashCode() : 0);
        result = 31 * result + (updateLatency != null ? updateLatency.hashCode() : 0);
        result = 31 * result + (rowsDeleted != null ? rowsDeleted.hashCode() : 0);
        result = 31 * result + (deleteLatency != null ? deleteLatency.hashCode() : 0);
        return result;
    }
}
