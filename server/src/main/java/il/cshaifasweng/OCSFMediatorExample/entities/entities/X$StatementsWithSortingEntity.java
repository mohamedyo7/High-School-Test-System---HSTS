package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "x$statements_with_sorting", schema = "sys", catalog = "")
public class X$StatementsWithSortingEntity {
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
    @Column(name = "sort_merge_passes")
    private Object sortMergePasses;
    @Basic
    @Column(name = "avg_sort_merges")
    private int avgSortMerges;
    @Basic
    @Column(name = "sorts_using_scans")
    private Object sortsUsingScans;
    @Basic
    @Column(name = "sort_using_range")
    private Object sortUsingRange;
    @Basic
    @Column(name = "rows_sorted")
    private Object rowsSorted;
    @Basic
    @Column(name = "avg_rows_sorted")
    private int avgRowsSorted;
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

    public Object getSortMergePasses() {
        return sortMergePasses;
    }

    public void setSortMergePasses(Object sortMergePasses) {
        this.sortMergePasses = sortMergePasses;
    }

    public int getAvgSortMerges() {
        return avgSortMerges;
    }

    public void setAvgSortMerges(int avgSortMerges) {
        this.avgSortMerges = avgSortMerges;
    }

    public Object getSortsUsingScans() {
        return sortsUsingScans;
    }

    public void setSortsUsingScans(Object sortsUsingScans) {
        this.sortsUsingScans = sortsUsingScans;
    }

    public Object getSortUsingRange() {
        return sortUsingRange;
    }

    public void setSortUsingRange(Object sortUsingRange) {
        this.sortUsingRange = sortUsingRange;
    }

    public Object getRowsSorted() {
        return rowsSorted;
    }

    public void setRowsSorted(Object rowsSorted) {
        this.rowsSorted = rowsSorted;
    }

    public int getAvgRowsSorted() {
        return avgRowsSorted;
    }

    public void setAvgRowsSorted(int avgRowsSorted) {
        this.avgRowsSorted = avgRowsSorted;
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

        X$StatementsWithSortingEntity that = (X$StatementsWithSortingEntity) o;

        if (avgSortMerges != that.avgSortMerges) return false;
        if (avgRowsSorted != that.avgRowsSorted) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (db != null ? !db.equals(that.db) : that.db != null) return false;
        if (execCount != null ? !execCount.equals(that.execCount) : that.execCount != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (sortMergePasses != null ? !sortMergePasses.equals(that.sortMergePasses) : that.sortMergePasses != null)
            return false;
        if (sortsUsingScans != null ? !sortsUsingScans.equals(that.sortsUsingScans) : that.sortsUsingScans != null)
            return false;
        if (sortUsingRange != null ? !sortUsingRange.equals(that.sortUsingRange) : that.sortUsingRange != null)
            return false;
        if (rowsSorted != null ? !rowsSorted.equals(that.rowsSorted) : that.rowsSorted != null) return false;
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
        result = 31 * result + (sortMergePasses != null ? sortMergePasses.hashCode() : 0);
        result = 31 * result + avgSortMerges;
        result = 31 * result + (sortsUsingScans != null ? sortsUsingScans.hashCode() : 0);
        result = 31 * result + (sortUsingRange != null ? sortUsingRange.hashCode() : 0);
        result = 31 * result + (rowsSorted != null ? rowsSorted.hashCode() : 0);
        result = 31 * result + avgRowsSorted;
        result = 31 * result + (firstSeen != null ? firstSeen.hashCode() : 0);
        result = 31 * result + (lastSeen != null ? lastSeen.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        return result;
    }
}
