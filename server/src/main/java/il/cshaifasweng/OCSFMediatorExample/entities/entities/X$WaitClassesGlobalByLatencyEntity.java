package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "x$wait_classes_global_by_latency", schema = "sys", catalog = "")
public class X$WaitClassesGlobalByLatencyEntity {
    @Basic
    @Column(name = "event_class")
    private String eventClass;
    @Basic
    @Column(name = "total")
    private Long total;
    @Basic
    @Column(name = "total_latency")
    private Long totalLatency;
    @Basic
    @Column(name = "min_latency")
    private Object minLatency;
    @Basic
    @Column(name = "avg_latency")
    private BigDecimal avgLatency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;

    public String getEventClass() {
        return eventClass;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Long totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(Object minLatency) {
        this.minLatency = minLatency;
    }

    public BigDecimal getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(BigDecimal avgLatency) {
        this.avgLatency = avgLatency;
    }

    public Object getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Object maxLatency) {
        this.maxLatency = maxLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        X$WaitClassesGlobalByLatencyEntity that = (X$WaitClassesGlobalByLatencyEntity) o;

        if (eventClass != null ? !eventClass.equals(that.eventClass) : that.eventClass != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (minLatency != null ? !minLatency.equals(that.minLatency) : that.minLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventClass != null ? eventClass.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (minLatency != null ? minLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        return result;
    }
}
