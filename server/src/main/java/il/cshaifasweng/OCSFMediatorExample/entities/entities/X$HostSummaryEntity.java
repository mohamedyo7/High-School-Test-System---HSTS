package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "x$host_summary", schema = "sys", catalog = "")
public class X$HostSummaryEntity {
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "statements")
    private BigInteger statements;
    @Basic
    @Column(name = "statement_latency")
    private BigInteger statementLatency;
    @Basic
    @Column(name = "statement_avg_latency")
    private BigDecimal statementAvgLatency;
    @Basic
    @Column(name = "table_scans")
    private BigInteger tableScans;
    @Basic
    @Column(name = "file_ios")
    private BigInteger fileIos;
    @Basic
    @Column(name = "file_io_latency")
    private BigInteger fileIoLatency;
    @Basic
    @Column(name = "current_connections")
    private Long currentConnections;
    @Basic
    @Column(name = "total_connections")
    private Long totalConnections;
    @Basic
    @Column(name = "unique_users")
    private long uniqueUsers;
    @Basic
    @Column(name = "current_memory")
    private BigInteger currentMemory;
    @Basic
    @Column(name = "total_memory_allocated")
    private BigInteger totalMemoryAllocated;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public BigInteger getStatements() {
        return statements;
    }

    public void setStatements(BigInteger statements) {
        this.statements = statements;
    }

    public BigInteger getStatementLatency() {
        return statementLatency;
    }

    public void setStatementLatency(BigInteger statementLatency) {
        this.statementLatency = statementLatency;
    }

    public BigDecimal getStatementAvgLatency() {
        return statementAvgLatency;
    }

    public void setStatementAvgLatency(BigDecimal statementAvgLatency) {
        this.statementAvgLatency = statementAvgLatency;
    }

    public BigInteger getTableScans() {
        return tableScans;
    }

    public void setTableScans(BigInteger tableScans) {
        this.tableScans = tableScans;
    }

    public BigInteger getFileIos() {
        return fileIos;
    }

    public void setFileIos(BigInteger fileIos) {
        this.fileIos = fileIos;
    }

    public BigInteger getFileIoLatency() {
        return fileIoLatency;
    }

    public void setFileIoLatency(BigInteger fileIoLatency) {
        this.fileIoLatency = fileIoLatency;
    }

    public Long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(Long currentConnections) {
        this.currentConnections = currentConnections;
    }

    public Long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(Long totalConnections) {
        this.totalConnections = totalConnections;
    }

    public long getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(long uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }

    public BigInteger getCurrentMemory() {
        return currentMemory;
    }

    public void setCurrentMemory(BigInteger currentMemory) {
        this.currentMemory = currentMemory;
    }

    public BigInteger getTotalMemoryAllocated() {
        return totalMemoryAllocated;
    }

    public void setTotalMemoryAllocated(BigInteger totalMemoryAllocated) {
        this.totalMemoryAllocated = totalMemoryAllocated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$HostSummaryEntity that = (X$HostSummaryEntity) o;

        if (uniqueUsers != that.uniqueUsers) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (statements != null ? !statements.equals(that.statements) : that.statements != null) return false;
        if (statementLatency != null ? !statementLatency.equals(that.statementLatency) : that.statementLatency != null)
            return false;
        if (statementAvgLatency != null ? !statementAvgLatency.equals(that.statementAvgLatency) : that.statementAvgLatency != null)
            return false;
        if (tableScans != null ? !tableScans.equals(that.tableScans) : that.tableScans != null) return false;
        if (fileIos != null ? !fileIos.equals(that.fileIos) : that.fileIos != null) return false;
        if (fileIoLatency != null ? !fileIoLatency.equals(that.fileIoLatency) : that.fileIoLatency != null)
            return false;
        if (currentConnections != null ? !currentConnections.equals(that.currentConnections) : that.currentConnections != null)
            return false;
        if (totalConnections != null ? !totalConnections.equals(that.totalConnections) : that.totalConnections != null)
            return false;
        if (currentMemory != null ? !currentMemory.equals(that.currentMemory) : that.currentMemory != null)
            return false;
        if (totalMemoryAllocated != null ? !totalMemoryAllocated.equals(that.totalMemoryAllocated) : that.totalMemoryAllocated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (statements != null ? statements.hashCode() : 0);
        result = 31 * result + (statementLatency != null ? statementLatency.hashCode() : 0);
        result = 31 * result + (statementAvgLatency != null ? statementAvgLatency.hashCode() : 0);
        result = 31 * result + (tableScans != null ? tableScans.hashCode() : 0);
        result = 31 * result + (fileIos != null ? fileIos.hashCode() : 0);
        result = 31 * result + (fileIoLatency != null ? fileIoLatency.hashCode() : 0);
        result = 31 * result + (currentConnections != null ? currentConnections.hashCode() : 0);
        result = 31 * result + (totalConnections != null ? totalConnections.hashCode() : 0);
        result = 31 * result + (int) (uniqueUsers ^ (uniqueUsers >>> 32));
        result = 31 * result + (currentMemory != null ? currentMemory.hashCode() : 0);
        result = 31 * result + (totalMemoryAllocated != null ? totalMemoryAllocated.hashCode() : 0);
        return result;
    }
}
