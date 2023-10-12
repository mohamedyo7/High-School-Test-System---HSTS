package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "x$statements_with_full_table_scans", schema = "sys", catalog = "")
public class X$StatementsWithFullTableScansEntity {
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
    @Column(name = "no_index_used_count")
    private Object noIndexUsedCount;
    @Basic
    @Column(name = "no_good_index_used_count")
    private Object noGoodIndexUsedCount;
    @Basic
    @Column(name = "no_index_used_pct")
    private int noIndexUsedPct;
    @Basic
    @Column(name = "rows_sent")
    private Object rowsSent;
    @Basic
    @Column(name = "rows_examined")
    private Object rowsExamined;
    @Basic
    @Column(name = "rows_sent_avg")
    private Integer rowsSentAvg;
    @Basic
    @Column(name = "rows_examined_avg")
    private Integer rowsExaminedAvg;
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

    public Object getNoIndexUsedCount() {
        return noIndexUsedCount;
    }

    public void setNoIndexUsedCount(Object noIndexUsedCount) {
        this.noIndexUsedCount = noIndexUsedCount;
    }

    public Object getNoGoodIndexUsedCount() {
        return noGoodIndexUsedCount;
    }

    public void setNoGoodIndexUsedCount(Object noGoodIndexUsedCount) {
        this.noGoodIndexUsedCount = noGoodIndexUsedCount;
    }

    public int getNoIndexUsedPct() {
        return noIndexUsedPct;
    }

    public void setNoIndexUsedPct(int noIndexUsedPct) {
        this.noIndexUsedPct = noIndexUsedPct;
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

    public Integer getRowsSentAvg() {
        return rowsSentAvg;
    }

    public void setRowsSentAvg(Integer rowsSentAvg) {
        this.rowsSentAvg = rowsSentAvg;
    }

    public Integer getRowsExaminedAvg() {
        return rowsExaminedAvg;
    }

    public void setRowsExaminedAvg(Integer rowsExaminedAvg) {
        this.rowsExaminedAvg = rowsExaminedAvg;
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

        X$StatementsWithFullTableScansEntity that = (X$StatementsWithFullTableScansEntity) o;

        if (noIndexUsedPct != that.noIndexUsedPct) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (db != null ? !db.equals(that.db) : that.db != null) return false;
        if (execCount != null ? !execCount.equals(that.execCount) : that.execCount != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (noIndexUsedCount != null ? !noIndexUsedCount.equals(that.noIndexUsedCount) : that.noIndexUsedCount != null)
            return false;
        if (noGoodIndexUsedCount != null ? !noGoodIndexUsedCount.equals(that.noGoodIndexUsedCount) : that.noGoodIndexUsedCount != null)
            return false;
        if (rowsSent != null ? !rowsSent.equals(that.rowsSent) : that.rowsSent != null) return false;
        if (rowsExamined != null ? !rowsExamined.equals(that.rowsExamined) : that.rowsExamined != null) return false;
        if (rowsSentAvg != null ? !rowsSentAvg.equals(that.rowsSentAvg) : that.rowsSentAvg != null) return false;
        if (rowsExaminedAvg != null ? !rowsExaminedAvg.equals(that.rowsExaminedAvg) : that.rowsExaminedAvg != null)
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
        result = 31 * result + (noIndexUsedCount != null ? noIndexUsedCount.hashCode() : 0);
        result = 31 * result + (noGoodIndexUsedCount != null ? noGoodIndexUsedCount.hashCode() : 0);
        result = 31 * result + noIndexUsedPct;
        result = 31 * result + (rowsSent != null ? rowsSent.hashCode() : 0);
        result = 31 * result + (rowsExamined != null ? rowsExamined.hashCode() : 0);
        result = 31 * result + (rowsSentAvg != null ? rowsSentAvg.hashCode() : 0);
        result = 31 * result + (rowsExaminedAvg != null ? rowsExaminedAvg.hashCode() : 0);
        result = 31 * result + (firstSeen != null ? firstSeen.hashCode() : 0);
        result = 31 * result + (lastSeen != null ? lastSeen.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        return result;
    }
}
