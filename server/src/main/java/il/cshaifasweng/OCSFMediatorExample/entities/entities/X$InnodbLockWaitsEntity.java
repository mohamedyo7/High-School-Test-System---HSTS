package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "x$innodb_lock_waits", schema = "sys", catalog = "")
public class X$InnodbLockWaitsEntity {
    @Basic
    @Column(name = "wait_started")
    private Timestamp waitStarted;
    @Basic
    @Column(name = "wait_age")
    private Time waitAge;
    @Basic
    @Column(name = "wait_age_secs")
    private Long waitAgeSecs;
    @Basic
    @Column(name = "locked_table")
    private String lockedTable;
    @Basic
    @Column(name = "locked_table_schema")
    private String lockedTableSchema;
    @Basic
    @Column(name = "locked_table_name")
    private String lockedTableName;
    @Basic
    @Column(name = "locked_table_partition")
    private String lockedTablePartition;
    @Basic
    @Column(name = "locked_table_subpartition")
    private String lockedTableSubpartition;
    @Basic
    @Column(name = "locked_index")
    private String lockedIndex;
    @Basic
    @Column(name = "locked_type")
    private String lockedType;
    @Basic
    @Column(name = "waiting_trx_id")
    private Object waitingTrxId;
    @Basic
    @Column(name = "waiting_trx_started")
    private Timestamp waitingTrxStarted;
    @Basic
    @Column(name = "waiting_trx_age")
    private Time waitingTrxAge;
    @Basic
    @Column(name = "waiting_trx_rows_locked")
    private Object waitingTrxRowsLocked;
    @Basic
    @Column(name = "waiting_trx_rows_modified")
    private Object waitingTrxRowsModified;
    @Basic
    @Column(name = "waiting_pid")
    private Object waitingPid;
    @Basic
    @Column(name = "waiting_query")
    private String waitingQuery;
    @Basic
    @Column(name = "waiting_lock_id")
    private String waitingLockId;
    @Basic
    @Column(name = "waiting_lock_mode")
    private String waitingLockMode;
    @Basic
    @Column(name = "blocking_trx_id")
    private Object blockingTrxId;
    @Basic
    @Column(name = "blocking_pid")
    private Object blockingPid;
    @Basic
    @Column(name = "blocking_query")
    private String blockingQuery;
    @Basic
    @Column(name = "blocking_lock_id")
    private String blockingLockId;
    @Basic
    @Column(name = "blocking_lock_mode")
    private String blockingLockMode;
    @Basic
    @Column(name = "blocking_trx_started")
    private Timestamp blockingTrxStarted;
    @Basic
    @Column(name = "blocking_trx_age")
    private Time blockingTrxAge;
    @Basic
    @Column(name = "blocking_trx_rows_locked")
    private Object blockingTrxRowsLocked;
    @Basic
    @Column(name = "blocking_trx_rows_modified")
    private Object blockingTrxRowsModified;
    @Basic
    @Column(name = "sql_kill_blocking_query")
    private String sqlKillBlockingQuery;
    @Basic
    @Column(name = "sql_kill_blocking_connection")
    private String sqlKillBlockingConnection;

    public Timestamp getWaitStarted() {
        return waitStarted;
    }

    public void setWaitStarted(Timestamp waitStarted) {
        this.waitStarted = waitStarted;
    }

    public Time getWaitAge() {
        return waitAge;
    }

    public void setWaitAge(Time waitAge) {
        this.waitAge = waitAge;
    }

    public Long getWaitAgeSecs() {
        return waitAgeSecs;
    }

    public void setWaitAgeSecs(Long waitAgeSecs) {
        this.waitAgeSecs = waitAgeSecs;
    }

    public String getLockedTable() {
        return lockedTable;
    }

    public void setLockedTable(String lockedTable) {
        this.lockedTable = lockedTable;
    }

    public String getLockedTableSchema() {
        return lockedTableSchema;
    }

    public void setLockedTableSchema(String lockedTableSchema) {
        this.lockedTableSchema = lockedTableSchema;
    }

    public String getLockedTableName() {
        return lockedTableName;
    }

    public void setLockedTableName(String lockedTableName) {
        this.lockedTableName = lockedTableName;
    }

    public String getLockedTablePartition() {
        return lockedTablePartition;
    }

    public void setLockedTablePartition(String lockedTablePartition) {
        this.lockedTablePartition = lockedTablePartition;
    }

    public String getLockedTableSubpartition() {
        return lockedTableSubpartition;
    }

    public void setLockedTableSubpartition(String lockedTableSubpartition) {
        this.lockedTableSubpartition = lockedTableSubpartition;
    }

    public String getLockedIndex() {
        return lockedIndex;
    }

    public void setLockedIndex(String lockedIndex) {
        this.lockedIndex = lockedIndex;
    }

    public String getLockedType() {
        return lockedType;
    }

    public void setLockedType(String lockedType) {
        this.lockedType = lockedType;
    }

    public Object getWaitingTrxId() {
        return waitingTrxId;
    }

    public void setWaitingTrxId(Object waitingTrxId) {
        this.waitingTrxId = waitingTrxId;
    }

    public Timestamp getWaitingTrxStarted() {
        return waitingTrxStarted;
    }

    public void setWaitingTrxStarted(Timestamp waitingTrxStarted) {
        this.waitingTrxStarted = waitingTrxStarted;
    }

    public Time getWaitingTrxAge() {
        return waitingTrxAge;
    }

    public void setWaitingTrxAge(Time waitingTrxAge) {
        this.waitingTrxAge = waitingTrxAge;
    }

    public Object getWaitingTrxRowsLocked() {
        return waitingTrxRowsLocked;
    }

    public void setWaitingTrxRowsLocked(Object waitingTrxRowsLocked) {
        this.waitingTrxRowsLocked = waitingTrxRowsLocked;
    }

    public Object getWaitingTrxRowsModified() {
        return waitingTrxRowsModified;
    }

    public void setWaitingTrxRowsModified(Object waitingTrxRowsModified) {
        this.waitingTrxRowsModified = waitingTrxRowsModified;
    }

    public Object getWaitingPid() {
        return waitingPid;
    }

    public void setWaitingPid(Object waitingPid) {
        this.waitingPid = waitingPid;
    }

    public String getWaitingQuery() {
        return waitingQuery;
    }

    public void setWaitingQuery(String waitingQuery) {
        this.waitingQuery = waitingQuery;
    }

    public String getWaitingLockId() {
        return waitingLockId;
    }

    public void setWaitingLockId(String waitingLockId) {
        this.waitingLockId = waitingLockId;
    }

    public String getWaitingLockMode() {
        return waitingLockMode;
    }

    public void setWaitingLockMode(String waitingLockMode) {
        this.waitingLockMode = waitingLockMode;
    }

    public Object getBlockingTrxId() {
        return blockingTrxId;
    }

    public void setBlockingTrxId(Object blockingTrxId) {
        this.blockingTrxId = blockingTrxId;
    }

    public Object getBlockingPid() {
        return blockingPid;
    }

    public void setBlockingPid(Object blockingPid) {
        this.blockingPid = blockingPid;
    }

    public String getBlockingQuery() {
        return blockingQuery;
    }

    public void setBlockingQuery(String blockingQuery) {
        this.blockingQuery = blockingQuery;
    }

    public String getBlockingLockId() {
        return blockingLockId;
    }

    public void setBlockingLockId(String blockingLockId) {
        this.blockingLockId = blockingLockId;
    }

    public String getBlockingLockMode() {
        return blockingLockMode;
    }

    public void setBlockingLockMode(String blockingLockMode) {
        this.blockingLockMode = blockingLockMode;
    }

    public Timestamp getBlockingTrxStarted() {
        return blockingTrxStarted;
    }

    public void setBlockingTrxStarted(Timestamp blockingTrxStarted) {
        this.blockingTrxStarted = blockingTrxStarted;
    }

    public Time getBlockingTrxAge() {
        return blockingTrxAge;
    }

    public void setBlockingTrxAge(Time blockingTrxAge) {
        this.blockingTrxAge = blockingTrxAge;
    }

    public Object getBlockingTrxRowsLocked() {
        return blockingTrxRowsLocked;
    }

    public void setBlockingTrxRowsLocked(Object blockingTrxRowsLocked) {
        this.blockingTrxRowsLocked = blockingTrxRowsLocked;
    }

    public Object getBlockingTrxRowsModified() {
        return blockingTrxRowsModified;
    }

    public void setBlockingTrxRowsModified(Object blockingTrxRowsModified) {
        this.blockingTrxRowsModified = blockingTrxRowsModified;
    }

    public String getSqlKillBlockingQuery() {
        return sqlKillBlockingQuery;
    }

    public void setSqlKillBlockingQuery(String sqlKillBlockingQuery) {
        this.sqlKillBlockingQuery = sqlKillBlockingQuery;
    }

    public String getSqlKillBlockingConnection() {
        return sqlKillBlockingConnection;
    }

    public void setSqlKillBlockingConnection(String sqlKillBlockingConnection) {
        this.sqlKillBlockingConnection = sqlKillBlockingConnection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$InnodbLockWaitsEntity that = (X$InnodbLockWaitsEntity) o;

        if (waitStarted != null ? !waitStarted.equals(that.waitStarted) : that.waitStarted != null) return false;
        if (waitAge != null ? !waitAge.equals(that.waitAge) : that.waitAge != null) return false;
        if (waitAgeSecs != null ? !waitAgeSecs.equals(that.waitAgeSecs) : that.waitAgeSecs != null) return false;
        if (lockedTable != null ? !lockedTable.equals(that.lockedTable) : that.lockedTable != null) return false;
        if (lockedTableSchema != null ? !lockedTableSchema.equals(that.lockedTableSchema) : that.lockedTableSchema != null)
            return false;
        if (lockedTableName != null ? !lockedTableName.equals(that.lockedTableName) : that.lockedTableName != null)
            return false;
        if (lockedTablePartition != null ? !lockedTablePartition.equals(that.lockedTablePartition) : that.lockedTablePartition != null)
            return false;
        if (lockedTableSubpartition != null ? !lockedTableSubpartition.equals(that.lockedTableSubpartition) : that.lockedTableSubpartition != null)
            return false;
        if (lockedIndex != null ? !lockedIndex.equals(that.lockedIndex) : that.lockedIndex != null) return false;
        if (lockedType != null ? !lockedType.equals(that.lockedType) : that.lockedType != null) return false;
        if (waitingTrxId != null ? !waitingTrxId.equals(that.waitingTrxId) : that.waitingTrxId != null) return false;
        if (waitingTrxStarted != null ? !waitingTrxStarted.equals(that.waitingTrxStarted) : that.waitingTrxStarted != null)
            return false;
        if (waitingTrxAge != null ? !waitingTrxAge.equals(that.waitingTrxAge) : that.waitingTrxAge != null)
            return false;
        if (waitingTrxRowsLocked != null ? !waitingTrxRowsLocked.equals(that.waitingTrxRowsLocked) : that.waitingTrxRowsLocked != null)
            return false;
        if (waitingTrxRowsModified != null ? !waitingTrxRowsModified.equals(that.waitingTrxRowsModified) : that.waitingTrxRowsModified != null)
            return false;
        if (waitingPid != null ? !waitingPid.equals(that.waitingPid) : that.waitingPid != null) return false;
        if (waitingQuery != null ? !waitingQuery.equals(that.waitingQuery) : that.waitingQuery != null) return false;
        if (waitingLockId != null ? !waitingLockId.equals(that.waitingLockId) : that.waitingLockId != null)
            return false;
        if (waitingLockMode != null ? !waitingLockMode.equals(that.waitingLockMode) : that.waitingLockMode != null)
            return false;
        if (blockingTrxId != null ? !blockingTrxId.equals(that.blockingTrxId) : that.blockingTrxId != null)
            return false;
        if (blockingPid != null ? !blockingPid.equals(that.blockingPid) : that.blockingPid != null) return false;
        if (blockingQuery != null ? !blockingQuery.equals(that.blockingQuery) : that.blockingQuery != null)
            return false;
        if (blockingLockId != null ? !blockingLockId.equals(that.blockingLockId) : that.blockingLockId != null)
            return false;
        if (blockingLockMode != null ? !blockingLockMode.equals(that.blockingLockMode) : that.blockingLockMode != null)
            return false;
        if (blockingTrxStarted != null ? !blockingTrxStarted.equals(that.blockingTrxStarted) : that.blockingTrxStarted != null)
            return false;
        if (blockingTrxAge != null ? !blockingTrxAge.equals(that.blockingTrxAge) : that.blockingTrxAge != null)
            return false;
        if (blockingTrxRowsLocked != null ? !blockingTrxRowsLocked.equals(that.blockingTrxRowsLocked) : that.blockingTrxRowsLocked != null)
            return false;
        if (blockingTrxRowsModified != null ? !blockingTrxRowsModified.equals(that.blockingTrxRowsModified) : that.blockingTrxRowsModified != null)
            return false;
        if (sqlKillBlockingQuery != null ? !sqlKillBlockingQuery.equals(that.sqlKillBlockingQuery) : that.sqlKillBlockingQuery != null)
            return false;
        if (sqlKillBlockingConnection != null ? !sqlKillBlockingConnection.equals(that.sqlKillBlockingConnection) : that.sqlKillBlockingConnection != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = waitStarted != null ? waitStarted.hashCode() : 0;
        result = 31 * result + (waitAge != null ? waitAge.hashCode() : 0);
        result = 31 * result + (waitAgeSecs != null ? waitAgeSecs.hashCode() : 0);
        result = 31 * result + (lockedTable != null ? lockedTable.hashCode() : 0);
        result = 31 * result + (lockedTableSchema != null ? lockedTableSchema.hashCode() : 0);
        result = 31 * result + (lockedTableName != null ? lockedTableName.hashCode() : 0);
        result = 31 * result + (lockedTablePartition != null ? lockedTablePartition.hashCode() : 0);
        result = 31 * result + (lockedTableSubpartition != null ? lockedTableSubpartition.hashCode() : 0);
        result = 31 * result + (lockedIndex != null ? lockedIndex.hashCode() : 0);
        result = 31 * result + (lockedType != null ? lockedType.hashCode() : 0);
        result = 31 * result + (waitingTrxId != null ? waitingTrxId.hashCode() : 0);
        result = 31 * result + (waitingTrxStarted != null ? waitingTrxStarted.hashCode() : 0);
        result = 31 * result + (waitingTrxAge != null ? waitingTrxAge.hashCode() : 0);
        result = 31 * result + (waitingTrxRowsLocked != null ? waitingTrxRowsLocked.hashCode() : 0);
        result = 31 * result + (waitingTrxRowsModified != null ? waitingTrxRowsModified.hashCode() : 0);
        result = 31 * result + (waitingPid != null ? waitingPid.hashCode() : 0);
        result = 31 * result + (waitingQuery != null ? waitingQuery.hashCode() : 0);
        result = 31 * result + (waitingLockId != null ? waitingLockId.hashCode() : 0);
        result = 31 * result + (waitingLockMode != null ? waitingLockMode.hashCode() : 0);
        result = 31 * result + (blockingTrxId != null ? blockingTrxId.hashCode() : 0);
        result = 31 * result + (blockingPid != null ? blockingPid.hashCode() : 0);
        result = 31 * result + (blockingQuery != null ? blockingQuery.hashCode() : 0);
        result = 31 * result + (blockingLockId != null ? blockingLockId.hashCode() : 0);
        result = 31 * result + (blockingLockMode != null ? blockingLockMode.hashCode() : 0);
        result = 31 * result + (blockingTrxStarted != null ? blockingTrxStarted.hashCode() : 0);
        result = 31 * result + (blockingTrxAge != null ? blockingTrxAge.hashCode() : 0);
        result = 31 * result + (blockingTrxRowsLocked != null ? blockingTrxRowsLocked.hashCode() : 0);
        result = 31 * result + (blockingTrxRowsModified != null ? blockingTrxRowsModified.hashCode() : 0);
        result = 31 * result + (sqlKillBlockingQuery != null ? sqlKillBlockingQuery.hashCode() : 0);
        result = 31 * result + (sqlKillBlockingConnection != null ? sqlKillBlockingConnection.hashCode() : 0);
        return result;
    }
}
