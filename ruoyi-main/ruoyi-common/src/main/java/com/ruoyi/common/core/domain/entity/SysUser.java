package com.ruoyi.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    /** 党支部ID */
    @Excel(name = "党支部编号", cellType = ColumnType.NUMERIC, prompt = "党支部编号，详情请见网站党支部管理")
    private Long deptId;

    /** 党支部对象 */
    @Excels({
            @Excel(name = "党支部名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "党支部负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /** 用户账号 */
    @Excel(name = "学号")
    private String userName;

    /** 用户昵称 */
    @Excel(name = "姓名")
    private String nickName;

    /** 用户民族 */
    @Excel(name = "民族")
    private String nation;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identityNumber;

    /** 班号 */
    @Excel(name = "班号")
    private String className;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    private String salt;

    /** 状态（0=申请入党积极分子,1=入党积极分子,2=发展对象,3=预备党员,4=正式党员） */
    @Excel(name = "状态", readConverterExp = "0=递交完入党申请书,1=入党积极分子,2=发展对象,3=预备党员,4=正式党员")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登录IP */
    @Excel(name = "最后登录IP", type = Type.EXPORT)
    private String loginIp;

    /** 登录时间 */
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date  loginDate;

    /** 递交入党申请书时间 */
    @Excel(name = "递交入党申请书时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  applyTime;

    /** 确认为积极分子时间 */
    @Excel(name = "确认为积极分子时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  activistsTime;

    /** 确认为发展对象时间 */
    @Excel(name = "确认为发展对象时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date   developTime;

    /** 确认为预备党员时间 */
    @Excel(name = "确认为预备党员时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  probationaryTime;

    /** 确认为正式党员时间 */
    @Excel(name = "确认为正式党员时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  officialTime;

    /** 出生年月 */
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  birthDay;



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getActivistsTime() {
        return activistsTime;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", nation='" + nation + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", className='" + className + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", applyTime=" + applyTime +
                ", activistsTime=" + activistsTime +
                ", developTime=" + developTime +
                ", probationaryTime=" + probationaryTime +
                ", officialTime=" + officialTime +
                ", birthDay=" + birthDay +
                ", dept=" + dept +
                '}';
    }

    public void setActivistsTime(Date activistsTime) {
        this.activistsTime = activistsTime;
    }

    public Date getDevelopTime() {
        return developTime;
    }

    public void setDevelopTime(Date developTime) {
        this.developTime = developTime;
    }

    public Date getProbationaryTime() {
        return probationaryTime;
    }

    public void setProbationaryTime(Date probationaryTime) {
        this.probationaryTime = probationaryTime;
    }

    public Date getOfficialTime() {
        return officialTime;
    }

    public void setOfficialTime(Date officialTime) {
        this.officialTime = officialTime;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /** 角色对象 */
    @Excels({
            @Excel(name = "角色名称", targetAttr = "roleName"),
            @Excel(name = "党支部负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    public SysUser()
    {

    }

    public SysUser(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNation()
    {
        return nation;
    }

    public void setNation(String nation)
    {
        this.nation = nation;
    }

    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

	@JsonIgnore
    @JsonProperty
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(Long[] postIds)
    {
        this.postIds = postIds;
    }

}
