<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!--党支部数据-->
      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-input
            v-model="deptName"
            placeholder="请输入党支部名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="deptOptions"
            :props="defaultProps"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="tree"
            default-expand-all
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <!--用户数据-->
      <el-col :span="20" :xs="34">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="学号" prop="userName">
            <el-input
              v-model="queryParams.userName"
              placeholder="请输入学号"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="姓名" prop="nickName">
            <el-input
              v-model="queryParams.nickName"
              placeholder="请输入姓名"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="目前身份" prop="status">
            <el-select
              v-model="queryParams.status"
              placeholder="用户目前身份"
              clearable
              size="small"
              style="width: 240px"
            >
              <el-option
                v-for="dict in statusOptions"
                :key="dict.dictValue"
                :label="dict.dictLabel"
                :value="dict.dictValue"
              />
            </el-select>
          </el-form-item>

          <el-form-item label="入党申请">
            <el-date-picker
              v-model="applydateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="积极分子">
            <el-date-picker
              v-model="activistdateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="推优日期">
            <el-date-picker
              v-model="promptdateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="发展对象">
            <el-date-picker
              v-model="developdateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="预备党员">
            <el-date-picker
              v-model="probationarydateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="正式党员">
            <el-date-picker
              v-model="officialdateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="出生年月日">
            <el-date-picker
              v-model="birthdateRange"
              size="small"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
            ></el-date-picker>
          </el-form-item>

          <el-form-item label="民族" prop="nation">
            <el-input
              v-model="queryParams.nation"
              placeholder="请输入民族"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="班号" prop="className">
            <el-input
              v-model="queryParams.className"
              placeholder="请输入班号"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="性别" prop="sex">
            <el-input
              v-model="queryParams.sex"
              placeholder="男=0，女=1，未知=2"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="身份证号" prop="identityNumber">
            <el-input
              v-model="queryParams.identityNumber"
              placeholder="请输入身份证号"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="计划发展批次" prop="developBatch">
            <el-input
              v-model="queryParams.developBatch"
              placeholder="请输入计划发展批次"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="导师ID" prop="tutorId">
            <el-input
              v-model="queryParams.tutorId"
              placeholder="请输入导师ID"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="导师姓名" prop="tutorName">
            <el-input
              v-model="queryParams.tutorName"
              placeholder="请输入导师姓名"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="导师所属学院研究中心" prop="searchCenter">
            <el-input
              v-model="queryParams.searchCenter"
              placeholder="请输入导师所属学院研究中心"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="备注" prop="remarks">
            <el-input
              v-model="queryParams.remarks"
              placeholder="请输入导师所属学院研究中心"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>
        <!--操作条-->
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
              v-hasPermi="['system:user:add']"
            >新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="el-icon-edit"
              size="mini"
              :disabled="single"
              @click="handleUpdate"
              v-hasPermi="['system:user:edit']"
            >修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="el-icon-delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
              v-hasPermi="['system:user:remove']"
            >删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="info"
              plain
              icon="el-icon-upload2"
              size="mini"
              @click="handleImport"
              v-hasPermi="['system:user:import']"
            >导入</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExport"
              v-hasPermi="['system:user:export']"
            >导出</el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
        </el-row>
        <!--信息展示表-->
        <el-table v-loading="loading" :data="userList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="用户编号" align="center" key="userId" prop="userId" v-if="columns[0].visible" />
          <el-table-column label="学号" width="120" align="center" key="userName" prop="userName" v-if="columns[1].visible" :show-overflow-tooltip="true" />
          <el-table-column label="姓名" align="center" key="nickName" prop="nickName" v-if="columns[2].visible" :show-overflow-tooltip="true" />
          <el-table-column label="民族" align="center" key="nation" prop="nation" v-if="columns[15].visible" :show-overflow-tooltip="true" />
          <el-table-column label="党支部" align="center" key="deptName" prop="dept.deptName" v-if="columns[3].visible" :show-overflow-tooltip="true" />
          <el-table-column label="班号" align="center" key="className" prop="className" v-if="columns[7].visible" width="120" />
          <el-table-column label="手机号码" align="center" key="phonenumber" prop="phonenumber" v-if="columns[4].visible" width="120" />
          <el-table-column label="目前身份" align="center" v-if="columns[5].visible" width="120" >
            <template slot-scope="scope" prop="status">
              <span v-if="scope.row.status==='0'">递交完入党申请书</span>
              <span v-if="scope.row.status==='1'">入党积极分子</span>
              <span v-if="scope.row.status==='2'">发展对象</span>
              <span v-if="scope.row.status==='3'">预备党员</span>
              <span v-if="scope.row.status==='4'">正式党员</span>
            </template>
          </el-table-column>

          <el-table-column label="性别" align="center" v-if="columns[5].visible" width="120" >
            <template slot-scope="scope" prop="sex">
              <span v-if="scope.row.sex==='0'">男</span>
              <span v-if="scope.row.sex==='1'">女</span>
              <span v-if="scope.row.sex==='2'">未知</span>
            </template>
          </el-table-column>
          <el-table-column label="出生年月日" align="center" prop="birthDay" v-if="columns[13].visible" width="160">
            <template slot-scope="scope">
              <span>{{parseTimeDay(scope.row.birthDay)}}</span>
            </template>
          </el-table-column>

          <el-table-column label="身份证号" align="center" key="identityNumber" prop="identityNumber" v-if="columns[12].visible" width="120" />


          <el-table-column label="递交入党申请书时间" align="center" prop="applyTime" v-if="columns[6].visible" width="160">
            <template slot-scope="scope">
              <span>{{parseTimeDay(scope.row.applyTime)}}</span>
            </template>
          </el-table-column>

          <el-table-column label="确认为积极分子时间" align="center" prop="activistsTime" v-if="columns[8].visible" width="160">
            <template slot-scope="scope">
              <span>{{ parseTimeDay(scope.row.activistsTime) }}</span>
            </template>
          </el-table-column>

          <el-table-column label="确认为发展对象时间" align="center" prop="developTime" v-if="columns[9].visible" width="160">
            <template slot-scope="scope">
              <span>{{parseTimeDay(scope.row.developTime) }}</span>
            </template>
          </el-table-column>

          <el-table-column label="确认为预备党员时间" align="center" prop="probationaryTime" v-if="columns[10].visible" width="160">
            <template slot-scope="scope">
              <span>{{parseTimeDay(scope.row.probationaryTime) }}</span>
            </template>
          </el-table-column>

          <el-table-column label="确认为正式时间" align="center" prop="officialTime" v-if="columns[11].visible" width="160">
            <template slot-scope="scope">
              <span>{{parseTimeDay(scope.row.officialTime)}}</span>
            </template>
          </el-table-column>

          <el-table-column label="推优时间" align="center" prop="promptTime" v-if="columns[16].visible" width="160">
            <template slot-scope="scope">
              <span>{{parseTimeDay(scope.row.promptTime)}}</span>
            </template>
          </el-table-column>

          <el-table-column label="计划发展批次" align="center" key="developBatch" prop="developBatch" v-if="columns[17].visible" :show-overflow-tooltip="true" />
          <el-table-column label="导师ID" align="center" key="tutorId" prop="tutorId" v-if="columns[18].visible" :show-overflow-tooltip="true" />
          <el-table-column label="导师姓名" align="center" key="tutorName" prop="tutorName" v-if="columns[19].visible" :show-overflow-tooltip="true" />
          <el-table-column label="导师所属学院研究中心" align="center" key="searchCenter" prop="searchCenter" v-if="columns[20].visible" :show-overflow-tooltip="true" />
          <el-table-column label="备注" align="center" key="remark" prop="remark" v-if="columns[14].visible" width="120" />


          <el-table-column
            label="操作"
            align="center"
            width="160"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:user:edit']"
              >修改</el-button>
              <el-button
                v-if="scope.row.userId !== 1"
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:user:remove']"
              >删除</el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-key"
                @click="handleResetPwd(scope.row)"
                v-hasPermi="['system:user:resetPwd']"
              >重置</el-button>
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名" prop="nickName">
              <el-input v-model="form.nickName" placeholder="请输入姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="党支部" prop="deptId">
              <treeselect v-model="form.deptId" :options="deptOptions" :show-count="true" placeholder="请选择归属党支部" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="手机号码" prop="phonenumber">
              <el-input v-model="form.phonenumber" placeholder="请输入手机号码" maxlength="11" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="邮箱" prop="email">
              <el-input v-model="form.email" placeholder="请输入邮箱" maxlength="50" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item v-if="form.userId == undefined" label="学号" prop="userName">
              <el-input v-model="form.userName" placeholder="请输入学号" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="form.userId == undefined" label="用户密码" prop="password">
              <el-input v-model="form.password" placeholder="请输入用户密码" type="password" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="用户性别">
              <el-select v-model="form.sex" placeholder="请选择">
                <el-option
                  v-for="dict in sexOptions"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="目前身份">
              <el-radio-group v-model="form.status">
                <el-radio
                  v-for="dict in statusOptions"
                  :key="dict.dictValue"
                  :label="dict.dictValue"
                >{{dict.dictLabel}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="支部任职">
              <el-select v-model="form.postIds" multiple placeholder="请选择">
                <el-option
                  v-for="item in postOptions"
                  :key="item.postId"
                  :label="item.postName"
                  :value="item.postId"
                  :disabled="item.status == 1"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="角色">
              <el-select v-model="form.roleIds" multiple placeholder="请选择">
                <el-option
                  v-for="item in roleOptions"
                  :key="item.roleId"
                  :label="item.roleName"
                  :value="item.roleId"
                  :disabled="item.status == 1"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="递交入党申请书时间" prop="applyTime">
              <el-date-picker
                v-model="form.applyTime"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="确认为积极分子时间" prop="activistsTime">
              <el-date-picker
                v-model="form.activistsTime"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="确认为发展对象时间" prop="developTime">
              <el-date-picker
                v-model="form.developTime"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="确认为预备党员时间" prop="probationaryTime">
              <el-date-picker
                v-model="form.probationaryTime"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="确认为正式党员时间" prop="officialTime">
              <el-date-picker
                v-model="form.officialTime"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="身份证号码" prop="identityNumber">
              <el-input v-model="form.identityNumber" placeholder="请输入身份证号码" maxlength="18" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="生日" prop="birthDay">
              <el-date-picker
                v-model="form.birthDay"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="班号" prop="className">
              <el-input v-model="form.className" placeholder="请输入班号"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="民族" prop="nation">
              <el-input v-model="form.nation" placeholder="请填写全名，如“汉族”" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="推优时间" prop="promptTime">
              <el-date-picker
                v-model="form.promptTime"
                size="small"
                style="width: 240px"
                value-format="yyyy-MM-dd"
                type="date"
                placeholder="选择日期"
              ></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="计划发展批次" prop="developBatch">
              <el-input v-model="form.developBatch" placeholder="请填写计划发展批次" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="导师ID" prop="tutorId">
              <el-input v-model="form.tutorId" placeholder="请填写导师ID（本科生不填）" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="导师姓名" prop="tutorName">
              <el-input v-model="form.tutorName" placeholder="请填写导师姓名（本科生不填）" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="导师所属学院研究中心" prop="searchCenter">
              <el-input v-model="form.searchCenter" placeholder="请填写导师所属学院研究中心（本科生不填）" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="备注">
              <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div class="el-upload__tip" slot="tip">
          <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的用户数据
          <el-link type="info" style="font-size:12px" @click="importTemplate">下载模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { listUser, getUser, delUser, addUser, updateUser, exportUser, resetUserPwd, changeUserStatus, importTemplate } from "@/api/system/user";
  import { getToken } from "@/utils/auth";
  import { treeselect } from "@/api/system/dept";
  import Treeselect from "@riophae/vue-treeselect";
  import "@riophae/vue-treeselect/dist/vue-treeselect.css";

  export default {
    name: "User",
    components: { Treeselect },
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 用户表格数据
        userList: null,
        // 弹出层标题
        title: "",
        // 党支部树选项
        deptOptions: undefined,
        // 是否显示弹出层
        open: false,
        // 党支部名称
        deptName: undefined,
        // 默认密码
        initPassword: undefined,
        //日期范围
        dateRange: [],
        //递交入党申请时间范围
        applydateRange: [],
        //成为积极分子时间范围
        activistdateRange: [],
        //成为发展对象时间范围
        developdateRange: [],
        //成为预备党员时间范围
        probationarydateRange: [],
        //成为正式党员时间范围
        officialdateRange: [],
        //推优时间范围
        promptdateRange: [],
        //生日范围
        birthdateRange: [],
        // 递交入党申请时间
        applyTime: "",
        // 成为积极分子时间
        activistsTime: "",
        // 成为发展对象时间
        developTime: "",
        // 成为预备党员时间
        probationaryTime: "",
        // 转正时间
        officialTime: "",
        // 目前身份数据字典
        statusOptions: [],
        // 性别状态字典
        sexOptions: [],
        // 支部任职选项
        postOptions: [],
        // 角色选项
        roleOptions: [],
        // 表单参数
        form: {},
        defaultProps: {
          children: "children",
          label: "label"
        },
        // 用户导入参数
        upload: {
          // 是否显示弹出层（用户导入）
          open: false,
          // 弹出层标题（用户导入）
          title: "",
          // 是否禁用上传
          isUploading: false,
          // 是否更新已经存在的用户数据
          updateSupport: 0,
          // 设置上传的请求头部
          headers: { Authorization: "Bearer " + getToken() },
          // 上传的地址
          url: process.env.VUE_APP_BASE_API + "/system/user/importData"
        },
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          //学号
          userName: undefined,
          //姓名
          nickName: undefined,
          //性别
          sex: undefined,
          //民族
          nation: undefined,
          //党支部
          deptId: undefined,
          //手机号码
          phonenumber: undefined,
          //目前身份
          status: undefined,
          //递交入党申请书时间
          applyTime : undefined,
          //团支部
          className: undefined,
          // 确认为积极分子时间
          activistsTime: undefined,
          // 确认为发展对象时间
          developTime: undefined,
          // 确认为预备党员时间
          probationaryTime: undefined,
          // 确认为正式党员时间
          officialTime: undefined,
          //身份证号
          identityNumber: undefined,
          //出生年月
          birthDay: undefined,
          //推优时间
          promptTime: undefined,
          //计划发展批次
          developBatch: undefined,
          //导师ID
          tutorId: undefined,
          //导师姓名
          tutorName: undefined,
          //导师所属学院研究中心
          searchCenter: undefined,
          //备注
          remarks : undefined,
        },
        // 列信息
        columns: [
          { key: 0, label: `用户编号`, visible: true },
          { key: 1, label: `学号`, visible: true },
          { key: 2, label: `姓名`, visible: true },
          { key: 3, label: `党支部`, visible: true },
          { key: 4, label: `手机号码`, visible: true },
          { key: 5, label: `目前身份`, visible: true },
          { key: 6, label: `递交入党申请书时间`, visible: true },
          { key: 7, label: `团支部`, visible: true },
          { key: 8, label: `确认为积极分子时间`, visible: true },
          { key: 9, label: `确认为发展对象时间`, visible: true },
          { key: 10, label: `确认为预备党员时间`, visible: true },
          { key: 11, label: `确认为正式党员时间`, visible: true },
          { key: 12, label: `身份证号`, visible: true },
          { key: 13, label: `出生年月`, visible: true },
          { key: 14, label: `备注`, visible: true },
          { key: 15, label: `民族`, visible: true },
          { key: 16, label: `推优时间`, visible: true },
          { key: 17, label: `计划发展批次`, visible: true },
          { key: 18, label: `导师ID`, visible: true },
          { key: 19, label: `导师姓名`, visible: true },
          { key: 20, label: `导师所属学院研究中心`, visible: true }
        ],
        // 表单校验
        rules: {
          userName: [
            { required: true, message: "学号不能为空", trigger: "blur" }
          ],
          nickName: [
            { required: true, message: "姓名不能为空", trigger: "blur" }
          ],
          password: [
            { required: true, message: "用户密码不能为空", trigger: "blur" }
          ],
          email: [
            {
              type: "email",
              message: "'请输入正确的邮箱地址",
              trigger: ["blur", "change"]
            }
          ],
          phonenumber: [
            {
              pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
              message: "请输入正确的手机号码",
              trigger: "blur"
            }
          ],
          identityNumber: [
            {

            }
          ]
        }
      };
    },
    watch: {
      // 根据名称筛选党支部树
      deptName(val) {
        this.$refs.tree.filter(val);
      }
    },
    created() {
      this.getList();
      this.getTreeselect();
      this.getDicts("sys_user_status").then(response => {
        this.statusOptions = response.data;
      });
      this.getDicts("sys_user_sex").then(response => {
        this.sexOptions = response.data;
      });
      this.getConfigKey("sys.user.initPassword").then(response => {
        this.initPassword = response.msg;
      });
    },
    methods: {
      parseTimeDay(value)
      {
        if(value==='')
          return '';
        const v=(value || "").split("T")[0];
        return v;
      },

      /** 查询用户列表 */
      getList() {
        this.loading = true;
        this.queryParams.params = {}
        if (null != this.applydateRange && '' != this.applydateRange) {
          this.queryParams.params["beginapply"] = this.applydateRange[0];
          this.queryParams.params["endapply"] = this.applydateRange[1];
        }
        if (null != this.activistdateRange && '' != this.activistdateRange) {
          this.queryParams.params["beginactivist"] = this.activistdateRange[0];
          this.queryParams.params["endactivist"] = this.activistdateRange[1];
        }
        if (null != this.developdateRange && '' != this.developdateRange) {
          this.queryParams.params["begindevelop"] = this.developdateRange[0];
          this.queryParams.params["enddevelop"] = this.developdateRange[1];
        }
        if (null != this.probationarydateRange && '' != this.probationarydateRange) {
          this.queryParams.params["beginprobationry"] = this.probationarydateRange[0];
          this.queryParams.params["endprobationry"] = this.probationarydateRange[1];
        }
        if (null != this.officialdateRange && '' != this.officialdateRange) {
          this.queryParams.params["beginofficial"] = this.officialdateRange[0];
          this.queryParams.params["endofficial"] = this.officialdateRange[1];
        }
        if (null != this.promptdateRange && '' != this.promptdateRange) {
          this.queryParams.params["beginprompt"] = this.promptdateRange[0];
          this.queryParams.params["endprompt"] = this.promptdateRange[1];
        }
        if (null != this.birthdateRange && '' != this.birthdateRange) {
          this.queryParams.params["beginbirth"] = this.birthdateRange[0];
          this.queryParams.params["endbirth"] = this.birthdateRange[1];
        }
        //
        // this.queryParams = this.addDateRange(this.queryParams,this.applydateRange,"apply");
        // this.queryParams = this.addDateRange(this.queryParams,this.activistdateRange,"activist");
        // this.queryParams = this.addDateRange(this.queryParams,this.developdateRange,"develop");
        // this.queryParams = this.addDateRange(this.queryParams,this.probationarydateRange,"probationry");
        // this.queryParams = this.addDateRange(this.queryParams,this.officialdateRange,"official");
        listUser(this.queryParams).then(response => {
            this.userList = response.rows;
            this.total = response.total;
            this.loading = false;
          }
        );
      },
      /** 查询党支部下拉树结构 */
      getTreeselect() {
        treeselect().then(response => {
          this.deptOptions = response.data;
        });
      },
      // 筛选节点
      filterNode(value, data) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
      },
      // 节点单击事件
      handleNodeClick(data) {
        this.queryParams.deptId = data.id;
        this.getList();
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          userName: undefined,
          nickName: undefined,
          nation:undefined,
          userId: undefined,
          deptId: undefined,
          password: undefined,
          phonenumber: undefined,
          email: undefined,
          sex: undefined,
          status: "0",
          applyTime : undefined,
          // 确认为积极分子时间
          activistsTime: undefined,
          // 确认为发展对象时间
          developTime: undefined,
          // 确认为预备党员时间
          probationaryTime: undefined,
          // 确认为正式党员时间
          officialTime: undefined,
          //身份证号
          identityNumber: undefined,
          //出生年月
          birthDay: undefined,
          //推优时间
          promptTime: undefined,
          //计划发展批次
          developBatch: undefined,
          //导师ID
          tutorId: undefined,
          //导师姓名
          tutorName: undefined,
          //导师所属学院研究中心
          searchCenter: undefined,
          remark: undefined,
          postIds: [],
          roleIds: []
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.page = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.dateRange = [];
        this.applydateRange = [];
        this.activistdateRange = [];
        this.developdateRange = [];
        this.probationarydateRange = [];
        this.officialdateRange = [];
        this.promptdateRange = [];
        this.birthdateRange = [];
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.userId);
        this.single = selection.length != 1;
        this.multiple = !selection.length;
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.getTreeselect();
        getUser().then(response => {
          this.postOptions = response.posts;
          this.roleOptions = response.roles;
          this.open = true;
          this.title = "添加用户";
          this.form.password = this.initPassword;
        });
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        this.getTreeselect();
        const userId = row.userId || this.ids;
        getUser(userId).then(response => {
          this.form = response.data;
          this.postOptions = response.posts;
          this.roleOptions = response.roles;
          this.form.postIds = response.postIds;
          this.form.roleIds = response.roleIds;
          this.open = true;
          this.title = "修改用户";
          this.form.password = "";
        });
      },
      /** 重置密码按钮操作 */
      handleResetPwd(row) {
        this.$prompt('请输入"' + row.userName + '"的新密码', "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消"
        }).then(({ value }) => {
          resetUserPwd(row.userId, value).then(response => {
            this.msgSuccess("修改成功，新密码是：" + value);
          });
        }).catch(() => {});
      },
      /** 提交按钮 */
      submitForm: function() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.userId != undefined) {
              updateUser(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addUser(this.form).then(response => {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const userIds = row.userId || this.ids;
        this.$confirm('是否确认删除用户编号为"' + userIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delUser(userIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有用户数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportUser(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
      },
      /** 导入按钮操作 */
      handleImport() {
        this.upload.title = "用户导入";
        this.upload.open = true;
      },
      /** 下载模板操作 */
      importTemplate() {
        importTemplate().then(response => {
          this.download(response.msg);
        });
      },
      // 文件上传中处理
      handleFileUploadProgress(event, file, fileList) {
        this.upload.isUploading = true;
      },
      // 文件上传成功处理
      handleFileSuccess(response, file, fileList) {
        this.upload.open = false;
        this.upload.isUploading = false;
        this.$refs.upload.clearFiles();
        this.$alert(response.msg, "导入结果", { dangerouslyUseHTMLString: true });
        this.getList();
      },
      // 提交上传文件
      submitFileForm() {
        this.$refs.upload.submit();
      }
    }
  };
</script>
