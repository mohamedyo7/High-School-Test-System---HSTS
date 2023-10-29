package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "x$statement_analysis", schema = "sys", catalog = "")
public class X$StatementAnalysisEntity {
    @Basic
    @Column(name = "query")
    private String query;
    @Basic
    @Column(name = "db")
    private String db;
    @Basic
    @Column(name = "full_scan")
    private String fullScan;
    @Basic
    @Column(name = "exec_count")
    private Object execCount;
    @Basic
    @Column(name = "exec_secondary_count")
    private Object execSecondaryCount;
    @Basic
    @Column(name = "err_count")
    private Object errCount;
    @Basic
    @Column(name = "warn_count")
    private Object warnCount;
    @Basic
    @Column(name = "total_latency")
    private Object totalLatency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;
    @Basic
    @Column(name = "avg_latency")
    private Object avgLatency;
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
    @Column(name = "rows_sent_avg")
    private int rowsSentAvg;
    @Basic
    @Column(name = "rows_examined")
    private Object rowsExamined;
    @Basic
    @Column(name = "rows_examined_avg")
    private int rowsExaminedAvg;
    @Basic
    @Column(name = "rows_affected")
    private Object rowsAffected;
    @Basic
    @Column(name = "rows_affected_avg")
    private int rowsAffectedAvg;
    @Basic
    @Column(name = "tmp_tables")
    private Object tmpTables;
    @Basic
    @Column(name = "tmp_disk_tables")
    private Object tmpDiskTables;
    @Basic
    @Column(name = "rows_sorted")
    private Object rowsSorted;
    @Basic
    @Column(name = "sort_merge_passes")
    private Object sortMergePasses;
    @Basic
    @Column(name = "max_controlled_memory")
    private Object maxControlledMemory;
    @Basic
    @Column(name = "max_total_memory")
    private Object maxTotalMemory;
    @Basic
    @Column(name = "digest")
    private String digest;
    @Basic
    @Column(name = "first_seen")
    private Timestamp firstSeen;
    @Basic
    @Column(name = "last_seen")
    private Timestamp lastSeen;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getFullScan() {
        return fullScan;
    }

    public void setFullScan(String fullScan) {
        this.fullScan = fullScan;
    }

    public Object getExecCount() {
        return execCount;
    }

    public void setExecCount(Object execCount) {
        this.execCount = execCount;
    }

    public Object getExecSecondaryCount() {
        return execSecondaryCount;
    }

    public void setExecSecondaryCount(Object execSecondaryCount) {
        this.execSecondaryCount = execSecondaryCount;
    }

    public Object getErrCount() {
        return errCount;
    }

    public void setErrCount(Object errCount) {
        this.errCount = errCount;
    }

    public Object getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Object warnCount) {
        this.warnCount = warnCount;
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

    public Object getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(Object avgLatency) {
        this.avgLatency = avgLatency;
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

    public int getRowsSentAvg() {
        return rowsSentAvg;
    }

    public void setRowsSentAvg(int rowsSentAvg) {
        this.rowsSentAvg = rowsSentAvg;
    }

    public Object getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Object rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public int getRowsExaminedAvg() {
        return rowsExaminedAvg;
    }

    public void setRowsExaminedAvg(int rowsExaminedAvg) {
        this.rowsExaminedAvg = rowsExaminedAvg;
    }

    public Object getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(Object rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public int getRowsAffectedAvg() {
        return rowsAffectedAvg;
    }

    public void setRowsAffectedAvg(int rowsAffectedAvg) {
        this.rowsAffectedAvg = rowsAffectedAvg;
    }

    public Object getTmpTables() {
        return tmpTables;
    }

    public void setTmpTables(Object tmpTables) {
        this.tmpTables = tmpTables;
    }

    public Object getTmpDiskTables() {
        return tmpDiskTables;
    }

    public void setTmpDiskTables(Object tmpDiskTables) {
        this.tmpDiskTables = tmpDiskTables;
    }

    public Object getRowsSorted() {
        return rowsSorted;
    }

    public void setRowsSorted(Object rowsSorted) {
        this.rowsSorted = rowsSorted;
    }

    public Object getSortMergePasses() {
        return sortMergePasses;
    }

    public void setSortMergePasses(Object sortMergePasses) {
        this.sortMergePasses = sortMergePasses;
    }

    public Object getMaxControlledMemory() {
        return maxControlledMemory;
    }

    public void setMaxControlledMemory(Object maxControlledMemory) {
        this.maxControlledMemory = maxControlledMemory;
    }

    public Object getMaxTotalMemory() {
        return maxTotalMemory;
    }

    public void setMaxTotalMemory(Object maxTotalMemory) {
        this.maxTotalMemory = maxTotalMemory;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Timestamp getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Timestamp firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Timestamp lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$StatementAnalysisEntity that = (X$StatementAnalysisEntity) o;

        if (rowsSentAvg != that.rowsSentAvg) return false;
        if (rowsExaminedAvg != that.rowsExaminedAvg) return false;
        if (rowsAffectedAvg != that.rowsAffectedAvg) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (db != null ? !db.equals(that.db) : that.db != null) return false;
        if (fullScan != null ? !fullScan.equals(that.fullScan) : that.fullScan != null) return false;
        if (execCount != null ? !execCount.equals(that.execCount) : that.execCount != null) return false;
        if (execSecondaryCount != null ? !execSecondaryCount.equals(that.execSecondaryCount) : that.execSecondaryCount != null)
            return false;
        if (errCount != null ? !errCount.equals(that.errCount) : that.errCount != null) return false;
        if (warnCount != null ? !warnCount.equals(that.warnCount) : that.warnCount != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (lockLatency != null ? !lockLatency.equals(that.lockLatency) : that.lockLatency != null) return false;
        if (cpuLatency != null ? !cpuLatency.equals(that.cpuLatency) : that.cpuLatency != null) return false;
        if (rowsSent != null ? !rowsSent.equals(that.rowsSent) : that.rowsSent != null) return false;
        if (rowsExamined != null ? !rowsExamined.equals(that.rowsExamined) : that.rowsExamined != null) return false;
        if (rowsAffected != null ? !rowsAffected.equals(that.rowsAffected) : that.rowsAffected != null) return false;
        if (tmpTables != null ? !tmpTables.equals(that.tmpTables) : that.tmpTables != null) return false;
        if (tmpDiskTables != null ? !tmpDiskTables.equals(that.tmpDiskTables) : that.tmpDiskTables != null)
            return false;
        if (rowsSorted != null ? !rowsSorted.equals(that.rowsSorted) : that.rowsSorted != null) return false;
        if (sortMergePasses != null ? !sortMergePasses.equals(that.sortMergePasses) : that.sortMergePasses != null)
            return false;
        if (maxControlledMemory != null ? !maxControlledMemory.equals(that.maxControlledMemory) : that.maxControlledMemory != null)
            return false;
        if (maxTotalMemory != null ? !maxTotalMemory.equals(that.maxTotalMemory) : that.maxTotalMemory != null)
            return false;
        if (digest != null ? !digest.equals(that.digest) : that.digest != null) return false;
        if (firstSeen != null ? !firstSeen.equals(that.firstSeen) : that.firstSeen != null) return false;
        if (lastSeen != null ? !lastSeen.equals(that.lastSeen) : that.lastSeen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = query != null ? query.hashCode() : 0;
        result = 31 * result + (db != null ? db.hashCode() : 0);
        result = 31 * result + (fullScan != null ? fullScan.hashCode() : 0);
        result = 31 * result + (execCount != null ? execCount.hashCode() : 0);
        result = 31 * result + (execSecondaryCount != null ? execSecondaryCount.hashCode() : 0);
        result = 31 * result + (errCount != null ? errCount.hashCode() : 0);
        result = 31 * result + (warnCount != null ? warnCount.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (lockLatency != null ? lockLatency.hashCode() : 0);
        result = 31 * result + (cpuLatency != null ? cpuLatency.hashCode() : 0);
        result = 31 * result + (rowsSent != null ? rowsSent.hashCode() : 0);
        result = 31 * result + rowsSentAvg;
        result = 31 * result + (rowsExamined != null ? rowsExamined.hashCode() : 0);
        result = 31 * result + rowsExaminedAvg;
        result = 31 * result + (rowsAffected != null ? rowsAffected.hashCode() : 0);
        result = 31 * result + rowsAffectedAvg;
        result = 31 * result + (tmpTables != null ? tmpTables.hashCode() : 0);
        result = 31 * result + (tmpDiskTables != null ? tmpDiskTables.hashCode() : 0);
        result = 31 * result + (rowsSorted != null ? rowsSorted.hashCode() : 0);
        result = 31 * result + (sortMergePasses != null ? sortMergePasses.hashCode() : 0);
        result = 31 * result + (maxControlledMemory != null ? maxControlledMemory.hashCode() : 0);
        result = 31 * result + (maxTotalMemory != null ? maxTotalMemory.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        result = 31 * result + (firstSeen != null ? firstSeen.hashCode() : 0);
        result = 31 * result + (lastSeen != null ? lastSeen.hashCode() : 0);
        return result;
    }
}
