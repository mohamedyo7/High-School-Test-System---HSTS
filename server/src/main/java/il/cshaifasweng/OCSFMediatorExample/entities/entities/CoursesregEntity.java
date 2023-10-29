package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coursesreg", schema = "sys", catalog = "")
public class CoursesregEntity {
    @Basic
    @Column(name = "course_name_Reg")
    private Integer courseNameReg;

    public Integer getCourseNameReg() {
        return courseNameReg;
    }

    public void setCourseNameReg(Integer courseNameReg) {
        this.courseNameReg = courseNameReg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesregEntity that = (CoursesregEntity) o;

        if (courseNameReg != null ? !courseNameReg.equals(that.courseNameReg) : that.courseNameReg != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return courseNameReg != null ? courseNameReg.hashCode() : 0;
    }
}
