package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "x$waits_by_user_by_latency", schema = "sys", catalog = "")
public class X$WaitsByUserByLatencyEntity {
    @Basic
    @Column(name = "user")
    private String user;
    @Basic
    @Column(name = "event")
    private String event;
    @Basic
    @Column(name = "total")
    private Object total;
    @Basic
    @Column(name = "total_latency")
    private Object totalLatency;
    @Basic
    @Column(name = "avg_latency")
    private Object avgLatency;
    @Basic
    @Column(name = "max_latency")
    private Object maxLatency;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public Object getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Object totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Object getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(Object avgLatency) {
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

        X$WaitsByUserByLatencyEntity that = (X$WaitsByUserByLatencyEntity) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (totalLatency != null ? !totalLatency.equals(that.totalLatency) : that.totalLatency != null) return false;
        if (avgLatency != null ? !avgLatency.equals(that.avgLatency) : that.avgLatency != null) return false;
        if (maxLatency != null ? !maxLatency.equals(that.maxLatency) : that.maxLatency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (totalLatency != null ? totalLatency.hashCode() : 0);
        result = 31 * result + (avgLatency != null ? avgLatency.hashCode() : 0);
        result = 31 * result + (maxLatency != null ? maxLatency.hashCode() : 0);
        return result;
    }
}
