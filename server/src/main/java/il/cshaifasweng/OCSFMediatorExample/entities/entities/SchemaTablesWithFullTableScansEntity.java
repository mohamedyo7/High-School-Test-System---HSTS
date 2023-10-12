package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schema_tables_with_full_table_scans", schema = "sys", catalog = "")
public class SchemaTablesWithFullTableScansEntity {
    @Basic
    @Column(name = "object_schema")
    private String objectSchema;
    @Basic
    @Column(name = "object_name")
    private String objectName;
    @Basic
    @Column(name = "rows_full_scanned")
    private Object rowsFullScanned;
    @Basic
    @Column(name = "latency")
    private String latency;

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

    public Object getRowsFullScanned() {
        return rowsFullScanned;
    }

    public void setRowsFullScanned(Object rowsFullScanned) {
        this.rowsFullScanned = rowsFullScanned;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchemaTablesWithFullTableScansEntity that = (SchemaTablesWithFullTableScansEntity) o;

        if (objectSchema != null ? !objectSchema.equals(that.objectSchema) : that.objectSchema != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (rowsFullScanned != null ? !rowsFullScanned.equals(that.rowsFullScanned) : that.rowsFullScanned != null)
            return false;
        if (latency != null ? !latency.equals(that.latency) : that.latency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectSchema != null ? objectSchema.hashCode() : 0;
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (rowsFullScanned != null ? rowsFullScanned.hashCode() : 0);
        result = 31 * result + (latency != null ? latency.hashCode() : 0);
        return result;
    }
}
