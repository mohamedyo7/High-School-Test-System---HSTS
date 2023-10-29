package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "session_ssl_status", schema = "sys", catalog = "")
public class SessionSslStatusEntity {
    @Basic
    @Column(name = "thread_id")
    private Object threadId;
    @Basic
    @Column(name = "ssl_version")
    private String sslVersion;
    @Basic
    @Column(name = "ssl_cipher")
    private String sslCipher;
    @Basic
    @Column(name = "ssl_sessions_reused")
    private String sslSessionsReused;

    public Object getThreadId() {
        return threadId;
    }

    public void setThreadId(Object threadId) {
        this.threadId = threadId;
    }

    public String getSslVersion() {
        return sslVersion;
    }

    public void setSslVersion(String sslVersion) {
        this.sslVersion = sslVersion;
    }

    public String getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher;
    }

    public String getSslSessionsReused() {
        return sslSessionsReused;
    }

    public void setSslSessionsReused(String sslSessionsReused) {
        this.sslSessionsReused = sslSessionsReused;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionSslStatusEntity that = (SessionSslStatusEntity) o;

        if (threadId != null ? !threadId.equals(that.threadId) : that.threadId != null) return false;
        if (sslVersion != null ? !sslVersion.equals(that.sslVersion) : that.sslVersion != null) return false;
        if (sslCipher != null ? !sslCipher.equals(that.sslCipher) : that.sslCipher != null) return false;
        if (sslSessionsReused != null ? !sslSessionsReused.equals(that.sslSessionsReused) : that.sslSessionsReused != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = threadId != null ? threadId.hashCode() : 0;
        result = 31 * result + (sslVersion != null ? sslVersion.hashCode() : 0);
        result = 31 * result + (sslCipher != null ? sslCipher.hashCode() : 0);
        result = 31 * result + (sslSessionsReused != null ? sslSessionsReused.hashCode() : 0);
        return result;
    }
}
