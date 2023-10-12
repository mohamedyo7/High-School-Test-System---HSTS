package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$schema_table_statistics_with_buffer", schema = "sys", catalog = "")
public class X$SchemaTableStatisticsWithBufferEntity {
    @Basic
    @Column(name = "table_schema")
    private String tableSchema;
    @Basic
    @Column(name = "table_name")
    private String tableName;
    @Basic
    @Column(name = "rows_fetched")
    private Object rowsFetched;
    @Basic
    @Column(name = "fetch_latency")
    private Object fetchLatency;
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
    @Basic
    @Column(name = "io_read_requests")
    private Long ioReadRequests;
    @Basic
    @Column(name = "io_read")
    private Long ioRead;
    @Basic
    @Column(name = "io_read_latency")
    private Long ioReadLatency;
    @Basic
    @Column(name = "io_write_requests")
    private Long ioWriteRequests;
    @Basic
    @Column(name = "io_write")
    private Long ioWrite;
    @Basic
    @Column(name = "io_write_latency")
    private Long ioWriteLatency;
    @Basic
    @Column(name = "io_misc_requests")
    private Long ioMiscRequests;
    @Basic
    @Column(name = "io_misc_latency")
    private Long ioMiscLatency;
    @Basic
    @Column(name = "innodb_buffer_allocated")
    private Long innodbBufferAllocated;
    @Basic
    @Column(name = "innodb_buffer_data")
    private Long innodbBufferData;
    @Basic
    @Column(name = "innodb_buffer_free")
    private Long innodbBufferFree;
    @Basic
    @Column(name = "innodb_buffer_pages")
    private Long innodbBufferPages;
    @Basic
    @Column(name = "innodb_buffer_pages_hashed")
    private Long innodbBufferPagesHashed;
    @Basic
    @Column(name = "innodb_buffer_pages_old")
    private Long innodbBufferPagesOld;
    @Basic
    @Column(name = "innodb_buffer_rows_cached")
    private Long innodbBufferRowsCached;

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

    public Object getRowsFetched() {
        return rowsFetched;
    }

    public void setRowsFetched(Object rowsFetched) {
        this.rowsFetched = rowsFetched;
    }

    public Object getFetchLatency() {
        return fetchLatency;
    }

    public void setFetchLatency(Object fetchLatency) {
        this.fetchLatency = fetchLatency;
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

    public Long getIoReadRequests() {
        return ioReadRequests;
    }

    public void setIoReadRequests(Long ioReadRequests) {
        this.ioReadRequests = ioReadRequests;
    }

    public Long getIoRead() {
        return ioRead;
    }

    public void setIoRead(Long ioRead) {
        this.ioRead = ioRead;
    }

    public Long getIoReadLatency() {
        return ioReadLatency;
    }

    public void setIoReadLatency(Long ioReadLatency) {
        this.ioReadLatency = ioReadLatency;
    }

    public Long getIoWriteRequests() {
        return ioWriteRequests;
    }

    public void setIoWriteRequests(Long ioWriteRequests) {
        this.ioWriteRequests = ioWriteRequests;
    }

    public Long getIoWrite() {
        return ioWrite;
    }

    public void setIoWrite(Long ioWrite) {
        this.ioWrite = ioWrite;
    }

    public Long getIoWriteLatency() {
        return ioWriteLatency;
    }

    public void setIoWriteLatency(Long ioWriteLatency) {
        this.ioWriteLatency = ioWriteLatency;
    }

    public Long getIoMiscRequests() {
        return ioMiscRequests;
    }

    public void setIoMiscRequests(Long ioMiscRequests) {
        this.ioMiscRequests = ioMiscRequests;
    }

    public Long getIoMiscLatency() {
        return ioMiscLatency;
    }

    public void setIoMiscLatency(Long ioMiscLatency) {
        this.ioMiscLatency = ioMiscLatency;
    }

    public Long getInnodbBufferAllocated() {
        return innodbBufferAllocated;
    }

    public void setInnodbBufferAllocated(Long innodbBufferAllocated) {
        this.innodbBufferAllocated = innodbBufferAllocated;
    }

    public Long getInnodbBufferData() {
        return innodbBufferData;
    }

    public void setInnodbBufferData(Long innodbBufferData) {
        this.innodbBufferData = innodbBufferData;
    }

    public Long getInnodbBufferFree() {
        return innodbBufferFree;
    }

    public void setInnodbBufferFree(Long innodbBufferFree) {
        this.innodbBufferFree = innodbBufferFree;
    }

    public Long getInnodbBufferPages() {
        return innodbBufferPages;
    }

    public void setInnodbBufferPages(Long innodbBufferPages) {
        this.innodbBufferPages = innodbBufferPages;
    }

    public Long getInnodbBufferPagesHashed() {
        return innodbBufferPagesHashed;
    }

    public void setInnodbBufferPagesHashed(Long innodbBufferPagesHashed) {
        this.innodbBufferPagesHashed = innodbBufferPagesHashed;
    }

    public Long getInnodbBufferPagesOld() {
        return innodbBufferPagesOld;
    }

    public void setInnodbBufferPagesOld(Long innodbBufferPagesOld) {
        this.innodbBufferPagesOld = innodbBufferPagesOld;
    }

    public Long getInnodbBufferRowsCached() {
        return innodbBufferRowsCached;
    }

    public void setInnodbBufferRowsCached(Long innodbBufferRowsCached) {
        this.innodbBufferRowsCached = innodbBufferRowsCached;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$SchemaTableStatisticsWithBufferEntity that = (X$SchemaTableStatisticsWithBufferEntity) o;

        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
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
        if (innodbBufferAllocated != null ? !innodbBufferAllocated.equals(that.innodbBufferAllocated) : that.innodbBufferAllocated != null)
            return false;
        if (innodbBufferData != null ? !innodbBufferData.equals(that.innodbBufferData) : that.innodbBufferData != null)
            return false;
        if (innodbBufferFree != null ? !innodbBufferFree.equals(that.innodbBufferFree) : that.innodbBufferFree != null)
            return false;
        if (innodbBufferPages != null ? !innodbBufferPages.equals(that.innodbBufferPages) : that.innodbBufferPages != null)
            return false;
        if (innodbBufferPagesHashed != null ? !innodbBufferPagesHashed.equals(that.innodbBufferPagesHashed) : that.innodbBufferPagesHashed != null)
            return false;
        if (innodbBufferPagesOld != null ? !innodbBufferPagesOld.equals(that.innodbBufferPagesOld) : that.innodbBufferPagesOld != null)
            return false;
        if (innodbBufferRowsCached != null ? !innodbBufferRowsCached.equals(that.innodbBufferRowsCached) : that.innodbBufferRowsCached != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
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
        result = 31 * result + (innodbBufferAllocated != null ? innodbBufferAllocated.hashCode() : 0);
        result = 31 * result + (innodbBufferData != null ? innodbBufferData.hashCode() : 0);
        result = 31 * result + (innodbBufferFree != null ? innodbBufferFree.hashCode() : 0);
        result = 31 * result + (innodbBufferPages != null ? innodbBufferPages.hashCode() : 0);
        result = 31 * result + (innodbBufferPagesHashed != null ? innodbBufferPagesHashed.hashCode() : 0);
        result = 31 * result + (innodbBufferPagesOld != null ? innodbBufferPagesOld.hashCode() : 0);
        result = 31 * result + (innodbBufferRowsCached != null ? innodbBufferRowsCached.hashCode() : 0);
        return result;
    }
}
