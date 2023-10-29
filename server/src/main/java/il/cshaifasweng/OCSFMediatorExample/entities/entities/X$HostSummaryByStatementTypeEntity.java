package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$host_summary_by_statement_type", schema = "sys", catalog = "")
public class X$HostSummaryByStatementTypeEntity {
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "statement")
    private String statement;
    @Basic
    @Column(name = "total")
    private Object total;
    @Basic
    @Column(name = "total_latency")
    private Object totalLatency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;
    @Basic
    @Column(name = "lock_latency")
    private Object lockLatency;
    @Basic
    @Column(name = "cpu_latency")
    private Object cpuLatency;
    @Basic
    @Column(name = "rows_sent")
    private Object rowsSent;
    @Basic
    @Column(name = "rows_examined")
    private Object rowsExamined;
    @Basic
    @Column(name = "rows_affected")
    private Object rowsAffected;
    @Basic
    @Column(name = "full_scans")
    private Object fullScans;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public Object getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Object totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Object maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Object getLockLatency() {
        return lockLatency;
    }

    public void setLockLatency(Object lockLatency) {
        this.lockLatency = lockLatency;
    }

    public Object getCpuLatency() {
        return cpuLatency;
    }

    public void setCpuLatency(Object cpuLatency) {
        this.cpuLatency = cpuLatency;
    }

    public Object getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Object rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Object getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Object rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public Object getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(Object rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public Object getFullScans() {
        return fullScans;
    }

    public void setFullScans(Object fullScans) {
        this.fullScans = fullScans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$HostSummaryByStatementTypeEntity that = (X$HostSummaryByStatementTypeEntity) o;

        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (statement != null ? !statement.equals(that.statement) : that.statement != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (lockLatency != null ? !lockLatency.equals(that.lockLatency) : that.lockLatency != null) return false;
        if (cpuLatency != null ? !cpuLatency.equals(that.cpuLatency) : that.cpuLatency != null) return false;
        if (rowsSent != null ? !rowsSent.equals(that.rowsSent) : that.rowsSent != null) return false;
        if (rowsExamined != null ? !rowsExamined.equals(that.rowsExamined) : that.rowsExamined != null) return false;
        if (rowsAffected != null ? !rowsAffected.equals(that.rowsAffected) : that.rowsAffected != null) return false;
        if (fullScans != null ? !fullScans.equals(that.fullScans) : that.fullScans != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (statement != null ? statement.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        result = 31 * result + (lockLatency != null ? lockLatency.hashCode() : 0);
        result = 31 * result + (cpuLatency != null ? cpuLatency.hashCode() : 0);
        result = 31 * result + (rowsSent != null ? rowsSent.hashCode() : 0);
        result = 31 * result + (rowsExamined != null ? rowsExamined.hashCode() : 0);
        result = 31 * result + (rowsAffected != null ? rowsAffected.hashCode() : 0);
        result = 31 * result + (fullScans != null ? fullScans.hashCode() : 0);
        return result;
    }
}
