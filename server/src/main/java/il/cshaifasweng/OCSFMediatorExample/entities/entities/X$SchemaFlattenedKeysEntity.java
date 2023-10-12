package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$schema_flattened_keys", schema = "sys", catalog = "")
public class X$SchemaFlattenedKeysEntity {
    @Basic
    @Column(name = "table_schema")
    private String tableSchema;
    @Basic
    @Column(name = "table_name")
    private String tableName;
    @Basic
    @Column(name = "index_name")
    private String indexName;
    @Basic
    @Column(name = "non_unique")
    private Integer nonUnique;
    @Basic
    @Column(name = "subpart_exists")
    private Long subpartExists;
    @Basic
    @Column(name = "index_columns")
    private String indexColumns;

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

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Integer getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(Integer nonUnique) {
        this.nonUnique = nonUnique;
    }

    public Long getSubpartExists() {
        return subpartExists;
    }

    public void setSubpartExists(Long subpartExists) {
        this.subpartExists = subpartExists;
    }

    public String getIndexColumns() {
        return indexColumns;
    }

    public void setIndexColumns(String indexColumns) {
        this.indexColumns = indexColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$SchemaFlattenedKeysEntity that = (X$SchemaFlattenedKeysEntity) o;

        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (indexName != null ? !indexName.equals(that.indexName) : that.indexName != null) return false;
        if (nonUnique != null ? !nonUnique.equals(that.nonUnique) : that.nonUnique != null) return false;
        if (subpartExists != null ? !subpartExists.equals(that.subpartExists) : that.subpartExists != null)
            return false;
        if (indexColumns != null ? !indexColumns.equals(that.indexColumns) : that.indexColumns != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableSchema != null ? tableSchema.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (indexName != null ? indexName.hashCode() : 0);
        result = 31 * result + (nonUnique != null ? nonUnique.hashCode() : 0);
        result = 31 * result + (subpartExists != null ? subpartExists.hashCode() : 0);
        result = 31 * result + (indexColumns != null ? indexColumns.hashCode() : 0);
        return result;
    }
}
