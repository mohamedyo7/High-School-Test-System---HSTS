package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$ps_schema_table_statistics_io", schema = "sys", catalog = "")
public class X$PsSchemaTableStatisticsIoEntity {
    @Basic
    @Column(name = "table_schema")
    private String tableSchema;
    @Basic
    @Column(name = "table_name")
    private String tableName;
    @Basic
    @Column(name = "count_read")
    private Long countRead;
    @Basic
    @Column(name = "sum_number_of_bytes_read")
    private Long sumNumberOfBytesRead;
    @Basic
    @Column(name = "sum_timer_read")
    private Long sumTimerRead;
    @Basic
    @Column(name = "count_write")
    private Long countWrite;
    @Basic
    @Column(name = "sum_number_of_bytes_write")
    private Long sumNumberOfBytesWrite;
    @Basic
    @Column(name = "sum_timer_write")
    private Long sumTimerWrite;
    @Basic
    @Column(name = "count_misc")
    private Long countMisc;
    @Basic
    @Column(name = "sum_timer_misc")
    private Long sumTimerMisc;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getCountRead() {
        return countRead;
    }

    public void setCountRead(Long countRead) {
        this.countRead = countRead;
    }

    public Long getSumNumberOfBytesRead() {
        return sumNumberOfBytesRead;
    }

    public void setSumNumberOfBytesRead(Long sumNumberOfBytesRead) {
        this.sumNumberOfBytesRead = sumNumberOfBytesRead;
    }

    public Long getSumTimerRead() {
        return sumTimerRead;
    }

    public void setSumTimerRead(Long sumTimerRead) {
        this.sumTimerRead = sumTimerRead;
    }

    public Long getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(Long countWrite) {
        this.countWrite = countWrite;
    }

    public Long getSumNumberOfBytesWrite() {
        return sumNumberOfBytesWrite;
    }

    public void setSumNumberOfBytesWrite(Long sumNumberOfBytesWrite) {
        this.sumNumberOfBytesWrite = sumNumberOfBytesWrite;
    }

    public Long getSumTimerWrite() {
        return sumTimerWrite;
    }

    public void setSumTimerWrite(Long sumTimerWrite) {
        this.sumTimerWrite = sumTimerWrite;
    }

    public Long getCountMisc() {
        return countMisc;
    }

    public void setCountMisc(Long countMisc) {
        this.countMisc = countMisc;
    }

    public Long getSumTimerMisc() {
        return sumTimerMisc;
    }

    public void setSumTimerMisc(Long sumTimerMisc) {
        this.sumTimerMisc = sumTimerMisc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$PsSchemaTableStatisticsIoEntity that = (X$PsSchemaTableStatisticsIoEntity) o;

        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (countRead != null ? !countRead.equals(that.countRead) : that.countRead != null) return false;
        if (sumNumberOfBytesRead != null ? !sumNumberOfBytesRead.equals(that.sumNumberOfBytesRead) : that.sumNumberOfBytesRead != null)
            return false;
        if (sumTimerRead != null ? !sumTimerRead.equals(that.sumTimerRead) : that.sumTimerRead != null) return false;
        if (countWrite != null ? !countWrite.equals(that.countWrite) : that.countWrite != null) return false;
        if (sumNumberOfBytesWrite != null ? !sumNumberOfBytesWrite.equals(that.sumNumberOfBytesWrite) : that.sumNumberOfBytesWrite != null)
            return false;
        if (sumTimerWrite != null ? !sumTimerWrite.equals(that.sumTimerWrite) : that.sumTimerWrite != null)
            return false;
        if (countMisc != null ? !countMisc.equals(that.countMisc) : that.countMisc != null) return false;
        if (sumTimerMisc != null ? !sumTimerMisc.equals(that.sumTimerMisc) : that.sumTimerMisc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (countRead != null ? countRead.hashCode() : 0);
        result = 31 * result + (sumNumberOfBytesRead != null ? sumNumberOfBytesRead.hashCode() : 0);
        result = 31 * result + (sumTimerRead != null ? sumTimerRead.hashCode() : 0);
        result = 31 * result + (countWrite != null ? countWrite.hashCode() : 0);
        result = 31 * result + (sumNumberOfBytesWrite != null ? sumNumberOfBytesWrite.hashCode() : 0);
        result = 31 * result + (sumTimerWrite != null ? sumTimerWrite.hashCode() : 0);
        result = 31 * result + (countMisc != null ? countMisc.hashCode() : 0);
        result = 31 * result + (sumTimerMisc != null ? sumTimerMisc.hashCode() : 0);
        return result;
    }
}
