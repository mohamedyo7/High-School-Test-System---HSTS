package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$ps_digest_avg_latency_distribution", schema = "sys", catalog = "")
public class X$PsDigestAvgLatencyDistributionEntity {
    @Basic
    @Column(name = "cnt")
    private long cnt;
    @Basic
    @Column(name = "avg_us")
    private Integer avgUs;

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public Integer getAvgUs() {
        return avgUs;
    }

    public void setAvgUs(Integer avgUs) {
        this.avgUs = avgUs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$PsDigestAvgLatencyDistributionEntity that = (X$PsDigestAvgLatencyDistributionEntity) o;

        if (cnt != that.cnt) return false;
        if (avgUs != null ? !avgUs.equals(that.avgUs) : that.avgUs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cnt ^ (cnt >>> 32));
        result = 31 * result + (avgUs != null ? avgUs.hashCode() : 0);
        return result;
    }
}
