package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "waits_by_host_by_latency", schema = "sys", catalog = "")
public class WaitsByHostByLatencyEntity {
    @Basic
    @Column(name = "host")
    private String host;
    @Basic
    @Column(name = "event")
    private String event;
    @Basic
    @Column(name = "total")
    private Object total;
    @Basic
    @Column(name = "total_latency")
    private String totalLatency;
    @Basic
    @Column(name = "avg_latency")
    private String avgLatency;
    @Basic
    @Column(name = "max_latency")
    private String maxLatency;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency;
    }

    public String getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(String avgLatency) {
        this.avgLatency = avgLatency;
    }

    public String getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(String maxLatency) {
        this.maxLatency = maxLatency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WaitsByHostByLatencyEntity that = (WaitsByHostByLatencyEntity) o;

        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        return result;
    }
}
