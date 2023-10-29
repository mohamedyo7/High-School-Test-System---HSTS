package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "x$ps_digest_95th_percentile_by_avg_us", schema = "sys", catalog = "")
public class X$PsDigest95ThPercentileByAvgUsEntity {
    @Basic
    @Column(name = "avg_us")
    private Integer avgUs;
    @Basic
    @Column(name = "percentile")
    private BigDecimal percentile;

    public Integer getAvgUs() {
        return avgUs;
    }

    public void setAvgUs(Integer avgUs) {
        this.avgUs = avgUs;
    }

    public BigDecimal getPercentile() {
        return percentile;
    }

    public void setPercentile(BigDecimal percentile) {
        this.percentile = percentile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$PsDigest95ThPercentileByAvgUsEntity that = (X$PsDigest95ThPercentileByAvgUsEntity) o;

        if (avgUs != null ? !avgUs.equals(that.avgUs) : that.avgUs != null) return false;
        if (percentile != null ? !percentile.equals(that.percentile) : that.percentile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = avgUs != null ? avgUs.hashCode() : 0;
        result = 31 * result + (percentile != null ? percentile.hashCode() : 0);
        return result;
    }
}
