<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <div class="slide">
          <div class="slideshow">
            <ul>
              <li v-for="(img, index) in imgArray" v-show="index===mark" :key="index">
                <a href="javascript:;">
                  <img :src='img'>
                </a>
              </li>
            </ul>
          </div>
          <div class="bar">
            <span v-for="(item, index) in imgArray" :class="{ 'active':index===mark }" :key="index"></span>
          </div>
        </div>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="15">
            <h3>党建办通知</h3>
            <el-table v-loading="loading" style="font-size: 13px" :show-header="false" class="customer-no-border-table" :data="noticeList">
              <el-table-column width="55" align="center" />
              <el-table-column
                label="公告标题"
                align="center"
                prop="noticeTitle"
                :show-overflow-tooltip="true"
              />
              <el-table-column label="创建时间" align="center" prop="createTime" width="100">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
                </template>
              </el-table-column>
              <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                  <el-button
                    size="mini"
                    type="text"
                    icon="el-icon-edit"
                    @click="handleUpdate(scope.row)"
                    v-hasPermi="['system:notice:query']"
                  >查看</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>系统升级情况</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="xxx活动 - 2021-02-22">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx活动 - 2020-12-14">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx活动 - 2020-11-18">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx活动 - 2020-10-10">
              <ol>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="xxx活动 - 2020-08-13">
              <ol>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="xxx活动 - 2020-07-20">
              <ol>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="xxx活动 - 2020-06-01">
              <ol>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="xxx活动 - 2020-03-18">
              <ol>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="xxx活动 - 2020-02-24">
              <ol>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="xxx活动 - 2019-12-02">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx活动 - 2019-11-11">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx活动 - 2019-10-08">
              <ol>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 党建信息网：<el-link
                href="www.gsgcpc.cn"
                target="_blank"
                >www.gsgcpc.cn</el-link
              >
            </p>
            <p>
              <i class="el-icon-user-solid"></i> 党建办QQ：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=2376617201&site=qq&menu=yes" target="_blank"
              > 2376617201</el-link>
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 党建办微信公众号：
              <el-link
                href="https://urlify.cn/zMRFBn" target="_blank"
              > 地大红色之翼</el-link>
            </p>

            <p>
              <i class="el-icon-chat-dot-round"></i> 党建办联系人：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=137721017&site=qq&menu=yes"
                >杨晗</el-link>
            </p>

            <p>
              <i class="el-icon-money"></i> 技术支持：<el-link
              href="https://jq.qq.com/?_wv=1027&k=PEUkcvu6"
            >淼淼靠你了</el-link>
            </p>

          </div>
        </el-card>
      </el-col>



      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>党建办负责人</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-user-solid"></i> 刘泽楷：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=614574823&site=qq&menu=yes" target="_blank"
              > 614574823</el-link>
            </p>
            <p>
              <i class="el-icon-user-solid"></i> 闫淑锦：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=2260273171&site=qq&menu=yes" target="_blank"
              > 2260273171</el-link>
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 涂可龙：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=1728834706&site=qq&menu=yes" target="_blank"
              > 1728834706</el-link>
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 徐文杰：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=2587817367&site=qq&menu=yes" target="_blank"
              > 2587817367</el-link>
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 张小溪：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=2402496861&site=qq&menu=yes" target="_blank"
              > 2402496861</el-link>
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 杨立言：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=1036822065&site=qq&menu=yes" target="_blank"
              > 1036822065</el-link>
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 李曾帅：
              <el-link
                href="http://wpa.qq.com/msgrd?v=3&uin=1932940046&site=qq&menu=yes" target="_blank"
              > 1932940046</el-link>
            </p>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 添加或修改公告对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
      <el-form ref="form" :model="form"  label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="公告标题" prop="noticeTitle">
              {{form.noticeTitle}}
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="内容">
              <editor v-model="form.noticeContent" :min-height="192"/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { listNotice, getNotice, delNotice, addNotice, updateNotice, exportNotice } from "@/api/system/notice";
import Editor from '@/components/ViewEditor';
export default {
  components: {
    Editor
  },
  data () {
    return {
      // 遮罩层
      open :false,
      loading: true,
      // 公告表格数据
      noticeList: [],
      // 弹出层标题
      title: "",

      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        noticeTitle: undefined,
        createBy: undefined,
        status: undefined
      },
      mark: 0, //比对图片索引的变量
      imgArray: [
        require('../assets/images/img1.jpg'),
        require('../assets/images/img1.jpg'),
        require('../assets/images/img1.jpg'),
        require('../assets/images/img1.jpg'),
      ],
      // 表单参数
      form: {}
    }
  },
  methods: {
    handleUpdate(row) {
      const noticeId = row.noticeId || this.ids
      getNotice(noticeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改公告";
      });
    },

    autoPlay () {
      this.mark++;
      if (this.mark === 4) { //当遍历到最后一张图片置零
        this.mark = 0
      }
    },
    play () {
      setInterval(this.autoPlay, 2500)
    },
    change (i) {
      this.mark = i
    },
    goTarget(href) {
      window.open(href, "_blank");
    },
    /** 查询公告列表 */
    getList() {
      this.loading = true;
      listNotice(this.queryParams).then(response => {
        this.noticeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
  },
  created () {
    this.getList();
    this.play()
  }
};
</script>
<style scoped>
.slide {
  width: 600px;
  height: 320px;
}
.slideshow {
  width: 600px;
  height: 320px;
}

img {
  width: 600px;
  height: 320px;
}
.bar {
  position: absolute;
  width: 45%;
  bottom: 10px;
  margin: 0 auto;
  z-index: 10;
  text-align: center;
}
.bar span {
  width: 20px;
  height: 5px;
  border: 1px solid;
  background: white;
  display: inline-block;
  margin-right: 10px;
}
.active {
  background: red !important;
}


</style>
<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>
<style>
/*去掉表格单元格边框*/
.customer-no-border-table th{
  border:none;
}
.customer-no-border-table td,.customer-no-border-table th.is-leaf {
  border:none;
}
/*表格最外边框*/
.customer-no-border-table .el-table--border, .el-table--group{
  border: none;
}
/*头部边框*/
.customer-no-border-table thead tr th.is-leaf{
  border: 0px solid #EBEEF5;
  border-right: none;
}
.customer-no-border-table thead tr th:nth-last-of-type(2){
  border-right: 0px solid #EBEEF5;
}
/*表格最外层边框-底部边框*/
.customer-no-border-table .el-table--border::after,.customer-no-border-table .el-table--group::after{
  width: 0;
}
.customer-no-border-table::before{
  width: 0;
}
.customer-no-border-table .el-table__fixed-right::before,.el-table__fixed::before{
  width: 0;
}
.customer-no-border-table .el-table__header tr th{
  background: #fff;
  color: #333333 ;
  padding: 3px ;
  fontWeight: 550 ;
  height: 36px ;
  border: 0px;
  font-size: 15px;
}
/*去掉鼠标悬停背景颜色*/
.el-table tbody tr:hover>td {
  background-color:#ffffff!important
}
</style>
