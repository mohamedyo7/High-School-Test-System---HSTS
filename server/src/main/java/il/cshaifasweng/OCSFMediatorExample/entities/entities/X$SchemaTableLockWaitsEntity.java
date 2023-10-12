package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$schema_table_lock_waits", schema = "sys", catalog = "")
public class X$SchemaTableLockWaitsEntity {
    @Basic
    @Column(name = "object_schema")
    private String objectSchema;
    @Basic
    @Column(name = "object_name")
    private String objectName;
    @Basic
    @Column(name = "waiting_thread_id")
    private Object waitingThreadId;
    @Basic
    @Column(name = "waiting_pid")
    private Object waitingPid;
    @Basic
    @Column(name = "waiting_account")
    private String waitingAccount;
    @Basic
    @Column(name = "waiting_lock_type")
    private String waitingLockType;
    @Basic
    @Column(name = "waiting_lock_duration")
    private String waitingLockDuration;
    @Basic
    @Column(name = "waiting_query")
    private String waitingQuery;
    @Basic
    @Column(name = "waiting_query_secs")
    private Long waitingQuerySecs;
    @Basic
    @Column(name = "waiting_query_rows_affected")
    private Object waitingQueryRowsAffected;
    @Basic
    @Column(name = "waiting_query_rows_examined")
    private Object waitingQueryRowsExamined;
    @Basic
    @Column(name = "blocking_thread_id")
    private Object blockingThreadId;
    @Basic
    @Column(name = "blocking_pid")
    private Object blockingPid;
    @Basic
    @Column(name = "blocking_account")
    private String blockingAccount;
    @Basic
    @Column(name = "blocking_lock_type")
    private String blockingLockType;
    @Basic
    @Column(name = "blocking_lock_duration")
    private String blockingLockDuration;
    @Basic
    @Column(name = "sql_kill_blocking_query")
    private String sqlKillBlockingQuery;
    @Basic
    @Column(name = "sql_kill_blocking_connection")
    private String sqlKillBlockingConnection;

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Object getWaitingThreadId() {
        return waitingThreadId;
    }

    public void setWaitingThreadId(Object waitingThreadId) {
        this.waitingThreadId = waitingThreadId;
    }

    public Object getWaitingPid() {
        return waitingPid;
    }

    public void setWaitingPid(Object waitingPid) {
        this.waitingPid = waitingPid;
    }

    public String getWaitingAccount() {
        return waitingAccount;
    }

    public void setWaitingAccount(String waitingAccount) {
        this.waitingAccount = waitingAccount;
    }

    public String getWaitingLockType() {
        return waitingLockType;
    }

    public void setWaitingLockType(String waitingLockType) {
        this.waitingLockType = waitingLockType;
    }

    public String getWaitingLockDuration() {
        return waitingLockDuration;
    }

    public void setWaitingLockDuration(String waitingLockDuration) {
        this.waitingLockDuration = waitingLockDuration;
    }

    public String getWaitingQuery() {
        return waitingQuery;
    }

    public void setWaitingQuery(String waitingQuery) {
        this.waitingQuery = waitingQuery;
    }

    public Long getWaitingQuerySecs() {
        return waitingQuerySecs;
    }

    public void setWaitingQuerySecs(Long waitingQuerySecs) {
        this.waitingQuerySecs = waitingQuerySecs;
    }

    public Object getWaitingQueryRowsAffected() {
        return waitingQueryRowsAffected;
    }

    public void setWaitingQueryRowsAffected(Object waitingQueryRowsAffected) {
        this.waitingQueryRowsAffected = waitingQueryRowsAffected;
    }

    public Object getWaitingQueryRowsExamined() {
        return waitingQueryRowsExamined;
    }

    public void setWaitingQueryRowsExamined(Object waitingQueryRowsExamined) {
        this.waitingQueryRowsExamined = waitingQueryRowsExamined;
    }

    public Object getBlockingThreadId() {
        return blockingThreadId;
    }

    public void setBlockingThreadId(Object blockingThreadId) {
        this.blockingThreadId = blockingThreadId;
    }

    public Object getBlockingPid() {
        return blockingPid;
    }

    public void setBlockingPid(Object blockingPid) {
        this.blockingPid = blockingPid;
    }

    public String getBlockingAccount() {
        return blockingAccount;
    }

    public void setBlockingAccount(String blockingAccount) {
        this.blockingAccount = blockingAccount;
    }

    public String getBlockingLockType() {
        return blockingLockType;
    }

    public void setBlockingLockType(String blockingLockType) {
        this.blockingLockType = blockingLockType;
    }

    public String getBlockingLockDuration() {
        return blockingLockDuration;
    }

    public void setBlockingLockDuration(String blockingLockDuration) {
        this.blockingLockDuration = blockingLockDuration;
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

        X$SchemaTableLockWaitsEntity that = (X$SchemaTableLockWaitsEntity) o;

        if (objectSchema != null ? !objectSchema.equals(that.objectSchema) : that.objectSchema != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (waitingThreadId != null ? !waitingThreadId.equals(that.waitingThreadId) : that.waitingThreadId != null)
            return false;
        if (waitingPid != null ? !waitingPid.equals(that.waitingPid) : that.waitingPid != null) return false;
        if (waitingAccount != null ? !waitingAccount.equals(that.waitingAccount) : that.waitingAccount != null)
            return false;
        if (waitingLockType != null ? !waitingLockType.equals(that.waitingLockType) : that.waitingLockType != null)
            return false;
        if (waitingLockDuration != null ? !waitingLockDuration.equals(that.waitingLockDuration) : that.waitingLockDuration != null)
            return false;
        if (waitingQuery != null ? !waitingQuery.equals(that.waitingQuery) : that.waitingQuery != null) return false;
        if (waitingQuerySecs != null ? !waitingQuerySecs.equals(that.waitingQuerySecs) : that.waitingQuerySecs != null)
            return false;
        if (waitingQueryRowsAffected != null ? !waitingQueryRowsAffected.equals(that.waitingQueryRowsAffected) : that.waitingQueryRowsAffected != null)
            return false;
        if (waitingQueryRowsExamined != null ? !waitingQueryRowsExamined.equals(that.waitingQueryRowsExamined) : that.waitingQueryRowsExamined != null)
            return false;
        if (blockingThreadId != null ? !blockingThreadId.equals(that.blockingThreadId) : that.blockingThreadId != null)
            return false;
        if (blockingPid != null ? !blockingPid.equals(that.blockingPid) : that.blockingPid != null) return false;
        if (blockingAccount != null ? !blockingAccount.equals(that.blockingAccount) : that.blockingAccount != null)
            return false;
        if (blockingLockType != null ? !blockingLockType.equals(that.blockingLockType) : that.blockingLockType != null)
            return false;
        if (blockingLockDuration != null ? !blockingLockDuration.equals(that.blockingLockDuration) : that.blockingLockDuration != null)
            return false;
        if (sqlKillBlockingQuery != null ? !sqlKillBlockingQuery.equals(that.sqlKillBlockingQuery) : that.sqlKillBlockingQuery != null)
            return false;
        if (sqlKillBlockingConnection != null ? !sqlKillBlockingConnection.equals(that.sqlKillBlockingConnection) : that.sqlKillBlockingConnection != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectSchema != null ? objectSchema.hashCode() : 0;
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (waitingThreadId != null ? waitingThreadId.hashCode() : 0);
        result = 31 * result + (waitingPid != null ? waitingPid.hashCode() : 0);
        result = 31 * result + (waitingAccount != null ? waitingAccount.hashCode() : 0);
        result = 31 * result + (waitingLockType != null ? waitingLockType.hashCode() : 0);
        result = 31 * result + (waitingLockDuration != null ? waitingLockDuration.hashCode() : 0);
        result = 31 * result + (waitingQuery != null ? waitingQuery.hashCode() : 0);
        result = 31 * result + (waitingQuerySecs != null ? waitingQuerySecs.hashCode() : 0);
        result = 31 * result + (waitingQueryRowsAffected != null ? waitingQueryRowsAffected.hashCode() : 0);
        result = 31 * result + (waitingQueryRowsExamined != null ? waitingQueryRowsExamined.hashCode() : 0);
        result = 31 * result + (blockingThreadId != null ? blockingThreadId.hashCode() : 0);
        result = 31 * result + (blockingPid != null ? blockingPid.hashCode() : 0);
        result = 31 * result + (blockingAccount != null ? blockingAccount.hashCode() : 0);
        result = 31 * result + (blockingLockType != null ? blockingLockType.hashCode() : 0);
        result = 31 * result + (blockingLockDuration != null ? blockingLockDuration.hashCode() : 0);
        result = 31 * result + (sqlKillBlockingQuery != null ? sqlKillBlockingQuery.hashCode() : 0);
        result = 31 * result + (sqlKillBlockingConnection != null ? sqlKillBlockingConnection.hashCode() : 0);
        return result;
    }
}
