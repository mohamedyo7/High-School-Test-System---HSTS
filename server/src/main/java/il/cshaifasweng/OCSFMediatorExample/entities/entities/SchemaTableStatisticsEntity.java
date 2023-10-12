package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schema_table_statistics", schema = "sys", catalog = "")
public class SchemaTableStatisticsEntity {
    @Basic
    @Column(name = "table_schema")
    private String tableSchema;
    @Basic
    @Column(name = "table_name")
    private String tableName;
    @Basic
    @Column(name = "total_latency")
    private String totalLatency;
    @Basic
    @Column(name = "rows_fetched")
    private Object rowsFetched;
    @Basic
    @Column(name = "fetch_latency")
    private String fetchLatency;
    @Basic
    @Column(name = "rows_inserted")
    private Object rowsInserted;
    @Basic
    @Column(name = "insert_latency")
    private String insertLatency;
    @Basic
    @Column(name = "rows_updated")
    private Object rowsUpdated;
    @Basic
    @Column(name = "update_latency")
    private String updateLatency;
    @Basic
    @Column(name = "rows_deleted")
    private Object rowsDeleted;
    @Basic
    @Column(name = "delete_latency")
    private String deleteLatency;
    @Basic
    @Column(name = "io_read_requests")
    private Long ioReadRequests;
    @Basic
    @Column(name = "io_read")
    private String ioRead;
    @Basic
    @Column(name = "io_read_latency")
    private String ioReadLatency;
    @Basic
    @Column(name = "io_write_requests")
    private Long ioWriteRequests;
    @Basic
    @Column(name = "io_write")
    private String ioWrite;
    @Basic
    @Column(name = "io_write_latency")
    private String ioWriteLatency;
    @Basic
    @Column(name = "io_misc_requests")
    private Long ioMiscRequests;
    @Basic
    @Column(name = "io_misc_latency")
    private String ioMiscLatency;

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

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getRowsFetched() {
        return rowsFetched;
    }

    public void setRowsFetched(Object rowsFetched) {
        this.rowsFetched = rowsFetched;
    }

    public String getFetchLatency() {
        return fetchLatency;
    }

    public void setFetchLatency(String fetchLatency) {
        this.fetchLatency = fetchLatency;
    }

    public Object getRowsInserted() {
        return rowsInserted;
    }

    public void setRowsInserted(Object rowsInserted) {
        this.rowsInserted = rowsInserted;
    }

    public String getInsertLatency() {
        return insertLatency;
    }

    public void setInsertLatency(String insertLatency) {
        this.insertLatency = insertLatency;
    }

    public Object getRowsUpdated() {
        return rowsUpdated;
    }

    public void setRowsUpdated(Object rowsUpdated) {
        this.rowsUpdated = rowsUpdated;
    }

    public String getUpdateLatency() {
        return updateLatency;
    }

    public void setUpdateLatency(String updateLatency) {
        this.updateLatency = updateLatency;
    }

    public Object getRowsDeleted() {
        return rowsDeleted;
    }

    public void setRowsDeleted(Object rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }

    public String getDeleteLatency() {
        return deleteLatency;
    }

    public void setDeleteLatency(String deleteLatency) {
        this.deleteLatency = deleteLatency;
    }

    public Long getIoReadRequests() {
        return ioReadRequests;
    }

    public void setIoReadRequests(Long ioReadRequests) {
        this.ioReadRequests = ioReadRequests;
    }

    public String getIoRead() {
        return ioRead;
    }

    public void setIoRead(String ioRead) {
        this.ioRead = ioRead;
    }

    public String getIoReadLatency() {
        return ioReadLatency;
    }

    public void setIoReadLatency(String ioReadLatency) {
        this.ioReadLatency = ioReadLatency;
    }

    public Long getIoWriteRequests() {
        return ioWriteRequests;
    }

    public void setIoWriteRequests(Long ioWriteRequests) {
        this.ioWriteRequests = ioWriteRequests;
    }

    public String getIoWrite() {
        return ioWrite;
    }

    public void setIoWrite(String ioWrite) {
        this.ioWrite = ioWrite;
    }

    public String getIoWriteLatency() {
        return ioWriteLatency;
    }

    public void setIoWriteLatency(String ioWriteLatency) {
        this.ioWriteLatency = ioWriteLatency;
    }

    public Long getIoMiscRequests() {
        return ioMiscRequests;
    }

    public void setIoMiscRequests(Long ioMiscRequests) {
        this.ioMiscRequests = ioMiscRequests;
    }

    public String getIoMiscLatency() {
        return ioMiscLatency;
    }

    public void setIoMiscLatency(String ioMiscLatency) {
        this.ioMiscLatency = ioMiscLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchemaTableStatisticsEntity that = (SchemaTableStatisticsEntity) o;

        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (rowsFetched != null ? !rowsFetched.equals(that.rowsFetched) : that.rowsFetched != null) return false;
        if (fetchLatency != null ? !fetchLatency.equals(that.fetchLatency) : that.fetchLatency != null) return false;
        if (rowsInserted != null ? !rowsInserted.equals(that.rowsInserted) : that.rowsInserted != null) return false;
        if (insertLatency != null ? !insertLatency.equals(that.insertLatency) : that.insertLatency != null)
            return false;
        if (rowsUpdated != null ? !rowsUpdated.equals(that.rowsUpdated) : that.rowsUpdated != null) return false;
        if (updateLatency != null ? !updateLatency.equals(that.updateLatency) : that.updateLatency != null)
            return false;
        if (rowsDeleted != null ? !rowsDeleted.equals(that.rowsDeleted) : that.rowsDeleted != null) return false;
        if (deleteLatency != null ? !deleteLatency.equals(that.deleteLatency) : that.deleteLatency != null)
            return false;
        if (ioReadRequests != null ? !ioReadRequests.equals(that.ioReadRequests) : that.ioReadRequests != null)
            return false;
        if (ioRead != null ? !ioRead.equals(that.ioRead) : that.ioRead != null) return false;
        if (ioReadLatency != null ? !ioReadLatency.equals(that.ioReadLatency) : that.ioReadLatency != null)
            return false;
        if (ioWriteRequests != null ? !ioWriteRequests.equals(that.ioWriteRequests) : that.ioWriteRequests != null)
            return false;
        if (ioWrite != null ? !ioWrite.equals(that.ioWrite) : that.ioWrite != null) return false;
        if (ioWriteLatency != null ? !ioWriteLatency.equals(that.ioWriteLatency) : that.ioWriteLatency != null)
            return false;
        if (ioMiscRequests != null ? !ioMiscRequests.equals(that.ioMiscRequests) : that.ioMiscRequests != null)
            return false;
        if (ioMiscLatency != null ? !ioMiscLatency.equals(that.ioMiscLatency) : that.ioMiscLatency != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (rowsFetched != null ? rowsFetched.hashCode() : 0);
        result = 31 * result + (fetchLatency != null ? fetchLatency.hashCode() : 0);
        result = 31 * result + (rowsInserted != null ? rowsInserted.hashCode() : 0);
        result = 31 * result + (insertLatency != null ? insertLatency.hashCode() : 0);
        result = 31 * result + (rowsUpdated != null ? rowsUpdated.hashCode() : 0);
        result = 31 * result + (updateLatency != null ? updateLatency.hashCode() : 0);
        result = 31 * result + (rowsDeleted != null ? rowsDeleted.hashCode() : 0);
        result = 31 * result + (deleteLatency != null ? deleteLatency.hashCode() : 0);
        result = 31 * result + (ioReadRequests != null ? ioReadRequests.hashCode() : 0);
        result = 31 * result + (ioRead != null ? ioRead.hashCode() : 0);
        result = 31 * result + (ioReadLatency != null ? ioReadLatency.hashCode() : 0);
        result = 31 * result + (ioWriteRequests != null ? ioWriteRequests.hashCode() : 0);
        result = 31 * result + (ioWrite != null ? ioWrite.hashCode() : 0);
        result = 31 * result + (ioWriteLatency != null ? ioWriteLatency.hashCode() : 0);
        result = 31 * result + (ioMiscRequests != null ? ioMiscRequests.hashCode() : 0);
        result = 31 * result + (ioMiscLatency != null ? ioMiscLatency.hashCode() : 0);
        return result;
    }
}
