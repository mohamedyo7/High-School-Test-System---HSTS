package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schema_unused_indexes", schema = "sys", catalog = "")
public class SchemaUnusedIndexesEntity {
    @Basic
    @Column(name = "object_schema")
    private String objectSchema;
    @Basic
    @Column(name = "object_name")
    private String objectName;
    @Basic
    @Column(name = "index_name")
    private String indexName;

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

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchemaUnusedIndexesEntity that = (SchemaUnusedIndexesEntity) o;

        if (objectSchema != null ? !objectSchema.equals(that.objectSchema) : that.objectSchema != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (indexName != null ? !indexName.equals(that.indexName) : that.indexName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectSchema != null ? objectSchema.hashCode() : 0;
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (indexName != null ? indexName.hashCode() : 0);
        return result;
    }
}
