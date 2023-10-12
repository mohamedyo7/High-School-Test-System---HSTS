package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "x$statements_with_temp_tables", schema = "sys", catalog = "")
public class X$StatementsWithTempTablesEntity {
    @Basic
    @Column(name = "query")
    private String query;
    @Basic
    @Column(name = "db")
    private String db;
    @Basic
    @Column(name = "exec_count")
    private Object execCount;
    @Basic
    @Column(name = "total_latency")
    private Object totalLatency;
    @Basic
    @Column(name = "memory_tmp_tables")
    private Object memoryTmpTables;
    @Basic
    @Column(name = "disk_tmp_tables")
    private Object diskTmpTables;
    @Basic
    @Column(name = "avg_tmp_tables_per_query")
    private int avgTmpTablesPerQuery;
    @Basic
    @Column(name = "tmp_tables_to_disk_pct")
    private int tmpTablesToDiskPct;
    @Basic
    @Column(name = "first_seen")
    private Timestamp firstSeen;
    @Basic
    @Column(name = "last_seen")
    private Timestamp lastSeen;
    @Basic
    @Column(name = "digest")
    private String digest;

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

    public Object getExecCount() {
        return execCount;
    }

    public void setExecCount(Object execCount) {
        this.execCount = execCount;
    }

    public Object getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Object totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getMemoryTmpTables() {
        return memoryTmpTables;
    }

    public void setMemoryTmpTables(Object memoryTmpTables) {
        this.memoryTmpTables = memoryTmpTables;
    }

    public Object getDiskTmpTables() {
        return diskTmpTables;
    }

    public void setDiskTmpTables(Object diskTmpTables) {
        this.diskTmpTables = diskTmpTables;
    }

    public int getAvgTmpTablesPerQuery() {
        return avgTmpTablesPerQuery;
    }

    public void setAvgTmpTablesPerQuery(int avgTmpTablesPerQuery) {
        this.avgTmpTablesPerQuery = avgTmpTablesPerQuery;
    }

    public int getTmpTablesToDiskPct() {
        return tmpTablesToDiskPct;
    }

    public void setTmpTablesToDiskPct(int tmpTablesToDiskPct) {
        this.tmpTablesToDiskPct = tmpTablesToDiskPct;
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

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$StatementsWithTempTablesEntity that = (X$StatementsWithTempTablesEntity) o;

        if (avgTmpTablesPerQuery != that.avgTmpTablesPerQuery) return false;
        if (tmpTablesToDiskPct != that.tmpTablesToDiskPct) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (db != null ? !db.equals(that.db) : that.db != null) return false;
        if (execCount != null ? !execCount.equals(that.execCount) : that.execCount != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (memoryTmpTables != null ? !memoryTmpTables.equals(that.memoryTmpTables) : that.memoryTmpTables != null)
            return false;
        if (diskTmpTables != null ? !diskTmpTables.equals(that.diskTmpTables) : that.diskTmpTables != null)
            return false;
        if (firstSeen != null ? !firstSeen.equals(that.firstSeen) : that.firstSeen != null) return false;
        if (lastSeen != null ? !lastSeen.equals(that.lastSeen) : that.lastSeen != null) return false;
        if (digest != null ? !digest.equals(that.digest) : that.digest != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = query != null ? query.hashCode() : 0;
        result = 31 * result + (db != null ? db.hashCode() : 0);
        result = 31 * result + (execCount != null ? execCount.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (memoryTmpTables != null ? memoryTmpTables.hashCode() : 0);
        result = 31 * result + (diskTmpTables != null ? diskTmpTables.hashCode() : 0);
        result = 31 * result + avgTmpTablesPerQuery;
        result = 31 * result + tmpTablesToDiskPct;
        result = 31 * result + (firstSeen != null ? firstSeen.hashCode() : 0);
        result = 31 * result + (lastSeen != null ? lastSeen.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        return result;
    }
}
