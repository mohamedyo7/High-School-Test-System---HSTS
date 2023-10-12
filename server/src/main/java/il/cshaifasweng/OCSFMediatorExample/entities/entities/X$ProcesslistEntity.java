package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "x$processlist", schema = "sys", catalog = "")
public class X$ProcesslistEntity {
    @Basic
    @Column(name = "thd_id")
    private Object thdId;
    @Basic
    @Column(name = "conn_id")
    private Object connId;
    @Basic
    @Column(name = "user")
    private String user;
    @Basic
    @Column(name = "db")
    private String db;
    @Basic
    @Column(name = "command")
    private String command;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "time")
    private Long time;
    @Basic
    @Column(name = "current_statement")
    private String currentStatement;
    @Basic
    @Column(name = "execution_engine")
    private Object executionEngine;
    @Basic
    @Column(name = "statement_latency")
    private Object statementLatency;
    @Basic
    @Column(name = "progress")
    private BigDecimal progress;
    @Basic
    @Column(name = "lock_latency")
    private Object lockLatency;
    @Basic
    @Column(name = "cpu_latency")
    private Object cpuLatency;
    @Basic
    @Column(name = "rows_examined")
    private Object rowsExamined;
    @Basic
    @Column(name = "rows_sent")
    private Object rowsSent;
    @Basic
    @Column(name = "rows_affected")
    private Object rowsAffected;
    @Basic
    @Column(name = "tmp_tables")
    private Object tmpTables;
    @Basic
    @Column(name = "tmp_disk_tables")
    private Object tmpDiskTables;
    @Basic
    @Column(name = "full_scan")
    private String fullScan;
    @Basic
    @Column(name = "last_statement")
    private String lastStatement;
    @Basic
    @Column(name = "last_statement_latency")
    private Object lastStatementLatency;
    @Basic
    @Column(name = "current_memory")
    private Long currentMemory;
    @Basic
    @Column(name = "last_wait")
    private String lastWait;
    @Basic
    @Column(name = "last_wait_latency")
    private String lastWaitLatency;
    @Basic
    @Column(name = "source")
    private String source;
    @Basic
    @Column(name = "trx_latency")
    private Object trxLatency;
    @Basic
    @Column(name = "trx_state")
    private Object trxState;
    @Basic
    @Column(name = "trx_autocommit")
    private Object trxAutocommit;
    @Basic
    @Column(name = "pid")
    private String pid;
    @Basic
    @Column(name = "program_name")
    private String programName;

    public Object getThdId() {
        return thdId;
    }

    public void setThdId(Object thdId) {
        this.thdId = thdId;
    }

    public Object getConnId() {
        return connId;
    }

    public void setConnId(Object connId) {
        this.connId = connId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getCurrentStatement() {
        return currentStatement;
    }

    public void setCurrentStatement(String currentStatement) {
        this.currentStatement = currentStatement;
    }

    public Object getExecutionEngine() {
        return executionEngine;
    }

    public void setExecutionEngine(Object executionEngine) {
        this.executionEngine = executionEngine;
    }

    public Object getStatementLatency() {
        return statementLatency;
    }

    public void setStatementLatency(Object statementLatency) {
        this.statementLatency = statementLatency;
    }

    public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
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

    public Object getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Object rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public Object getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Object rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Object getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(Object rowsAffected) {
        this.rowsAffected = rowsAffected;
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

    public String getFullScan() {
        return fullScan;
    }

    public void setFullScan(String fullScan) {
        this.fullScan = fullScan;
    }

    public String getLastStatement() {
        return lastStatement;
    }

    public void setLastStatement(String lastStatement) {
        this.lastStatement = lastStatement;
    }

    public Object getLastStatementLatency() {
        return lastStatementLatency;
    }

    public void setLastStatementLatency(Object lastStatementLatency) {
        this.lastStatementLatency = lastStatementLatency;
    }

    public Long getCurrentMemory() {
        return currentMemory;
    }

    public void setCurrentMemory(Long currentMemory) {
        this.currentMemory = currentMemory;
    }

    public String getLastWait() {
        return lastWait;
    }

    public void setLastWait(String lastWait) {
        this.lastWait = lastWait;
    }

    public String getLastWaitLatency() {
        return lastWaitLatency;
    }

    public void setLastWaitLatency(String lastWaitLatency) {
        this.lastWaitLatency = lastWaitLatency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getTrxLatency() {
        return trxLatency;
    }

    public void setTrxLatency(Object trxLatency) {
        this.trxLatency = trxLatency;
    }

    public Object getTrxState() {
        return trxState;
    }

    public void setTrxState(Object trxState) {
        this.trxState = trxState;
    }

    public Object getTrxAutocommit() {
        return trxAutocommit;
    }

    public void setTrxAutocommit(Object trxAutocommit) {
        this.trxAutocommit = trxAutocommit;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$ProcesslistEntity that = (X$ProcesslistEntity) o;

        if (thdId != null ? !thdId.equals(that.thdId) : that.thdId != null) return false;
        if (connId != null ? !connId.equals(that.connId) : that.connId != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (db != null ? !db.equals(that.db) : that.db != null) return false;
        if (command != null ? !command.equals(that.command) : that.command != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (currentStatement != null ? !currentStatement.equals(that.currentStatement) : that.currentStatement != null)
            return false;
        if (executionEngine != null ? !executionEngine.equals(that.executionEngine) : that.executionEngine != null)
            return false;
        if (statementLatency != null ? !statementLatency.equals(that.statementLatency) : that.statementLatency != null)
            return false;
        if (progress != null ? !progress.equals(that.progress) : that.progress != null) return false;
        if (lockLatency != null ? !lockLatency.equals(that.lockLatency) : that.lockLatency != null) return false;
        if (cpuLatency != null ? !cpuLatency.equals(that.cpuLatency) : that.cpuLatency != null) return false;
        if (rowsExamined != null ? !rowsExamined.equals(that.rowsExamined) : that.rowsExamined != null) return false;
        if (rowsSent != null ? !rowsSent.equals(that.rowsSent) : that.rowsSent != null) return false;
        if (rowsAffected != null ? !rowsAffected.equals(that.rowsAffected) : that.rowsAffected != null) return false;
        if (tmpTables != null ? !tmpTables.equals(that.tmpTables) : that.tmpTables != null) return false;
        if (tmpDiskTables != null ? !tmpDiskTables.equals(that.tmpDiskTables) : that.tmpDiskTables != null)
            return false;
        if (fullScan != null ? !fullScan.equals(that.fullScan) : that.fullScan != null) return false;
        if (lastStatement != null ? !lastStatement.equals(that.lastStatement) : that.lastStatement != null)
            return false;
        if (lastStatementLatency != null ? !lastStatementLatency.equals(that.lastStatementLatency) : that.lastStatementLatency != null)
            return false;
        if (currentMemory != null ? !currentMemory.equals(that.currentMemory) : that.currentMemory != null)
            return false;
        if (lastWait != null ? !lastWait.equals(that.lastWait) : that.lastWait != null) return false;
        if (lastWaitLatency != null ? !lastWaitLatency.equals(that.lastWaitLatency) : that.lastWaitLatency != null)
            return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (trxLatency != null ? !trxLatency.equals(that.trxLatency) : that.trxLatency != null) return false;
        if (trxState != null ? !trxState.equals(that.trxState) : that.trxState != null) return false;
        if (trxAutocommit != null ? !trxAutocommit.equals(that.trxAutocommit) : that.trxAutocommit != null)
            return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (programName != null ? !programName.equals(that.programName) : that.programName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = thdId != null ? thdId.hashCode() : 0;
        result = 31 * result + (connId != null ? connId.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (db != null ? db.hashCode() : 0);
        result = 31 * result + (command != null ? command.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (currentStatement != null ? currentStatement.hashCode() : 0);
        result = 31 * result + (executionEngine != null ? executionEngine.hashCode() : 0);
        result = 31 * result + (statementLatency != null ? statementLatency.hashCode() : 0);
        result = 31 * result + (progress != null ? progress.hashCode() : 0);
        result = 31 * result + (lockLatency != null ? lockLatency.hashCode() : 0);
        result = 31 * result + (cpuLatency != null ? cpuLatency.hashCode() : 0);
        result = 31 * result + (rowsExamined != null ? rowsExamined.hashCode() : 0);
        result = 31 * result + (rowsSent != null ? rowsSent.hashCode() : 0);
        result = 31 * result + (rowsAffected != null ? rowsAffected.hashCode() : 0);
        result = 31 * result + (tmpTables != null ? tmpTables.hashCode() : 0);
        result = 31 * result + (tmpDiskTables != null ? tmpDiskTables.hashCode() : 0);
        result = 31 * result + (fullScan != null ? fullScan.hashCode() : 0);
        result = 31 * result + (lastStatement != null ? lastStatement.hashCode() : 0);
        result = 31 * result + (lastStatementLatency != null ? lastStatementLatency.hashCode() : 0);
        result = 31 * result + (currentMemory != null ? currentMemory.hashCode() : 0);
        result = 31 * result + (lastWait != null ? lastWait.hashCode() : 0);
        result = 31 * result + (lastWaitLatency != null ? lastWaitLatency.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (trxLatency != null ? trxLatency.hashCode() : 0);
        result = 31 * result + (trxState != null ? trxState.hashCode() : 0);
        result = 31 * result + (trxAutocommit != null ? trxAutocommit.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (programName != null ? programName.hashCode() : 0);
        return result;
    }
}
