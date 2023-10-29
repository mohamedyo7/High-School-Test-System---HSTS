package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "x$statements_with_errors_or_warnings", schema = "sys", catalog = "")
public class X$StatementsWithErrorsOrWarningsEntity {
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
    @Column(name = "errors")
    private Object errors;
    @Basic
    @Column(name = "error_pct")
    private BigDecimal errorPct;
    @Basic
    @Column(name = "warnings")
    private Object warnings;
    @Basic
    @Column(name = "warning_pct")
    private BigDecimal warningPct;
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

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public BigDecimal getErrorPct() {
        return errorPct;
    }

    public void setErrorPct(BigDecimal errorPct) {
        this.errorPct = errorPct;
    }

    public Object getWarnings() {
        return warnings;
    }

    public void setWarnings(Object warnings) {
        this.warnings = warnings;
    }

    public BigDecimal getWarningPct() {
        return warningPct;
    }

    public void setWarningPct(BigDecimal warningPct) {
        this.warningPct = warningPct;
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

        X$StatementsWithErrorsOrWarningsEntity that = (X$StatementsWithErrorsOrWarningsEntity) o;

        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (db != null ? !db.equals(that.db) : that.db != null) return false;
        if (execCount != null ? !execCount.equals(that.execCount) : that.execCount != null) return false;
        if (errors != null ? !errors.equals(that.errors) : that.errors != null) return false;
        if (errorPct != null ? !errorPct.equals(that.errorPct) : that.errorPct != null) return false;
        if (warnings != null ? !warnings.equals(that.warnings) : that.warnings != null) return false;
        if (warningPct != null ? !warningPct.equals(that.warningPct) : that.warningPct != null) return false;
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
        result = 31 * result + (errors != null ? errors.hashCode() : 0);
        result = 31 * result + (errorPct != null ? errorPct.hashCode() : 0);
        result = 31 * result + (warnings != null ? warnings.hashCode() : 0);
        result = 31 * result + (warningPct != null ? warningPct.hashCode() : 0);
        result = 31 * result + (firstSeen != null ? firstSeen.hashCode() : 0);
        result = 31 * result + (lastSeen != null ? lastSeen.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        return result;
    }
}
