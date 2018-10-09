<template>
  <div id='studentList' class="row">
    <h1 style="margin-left: 493px;margin-top: 21px;">{{msg}}</h1>
    <span style="margin-left: 493px;margin-top: 21px;" >  <router-link to="/addStudent"> Add Student </router-link> </span>
      <div class="row" style="margin-left: 493px;margin-top: 21px;">
        <table class="table .table-bordered">
          <tr  v-for="item in student " v-bind:key="item">
            <td>
              {{item.firstName + " " + item.lastName}}
            </td>
             <td>
              <button v-on:click.prevent="updateData(item.studentId)" class="btn btn-success">Update</button>
            </td>
            <td>
             <button v-on:click.prevent="deleteData(item.studentId)" class="btn btn-success">Delete</button>
            </td>
          </tr>
        </table>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
export default {
  name: 'studentList',
  data () {
    return {
      msg: 'Student List',
      student: [],
      studentDetail: {
        firstName: '',
        lastName: '',
        fatherName: '',
        middleName: '',
        age: '',
        studentId: ''
      }
    }
  },
  created: function () {
    this.getStudentDetail() // method1 will execute at pageload
  },
  mounted: function () {
    this.getStudentDetail() // method1 will execute at pageload
  },
  methods: {
    getStudentDetail () {
      axios({
        method: 'GET',
        'url': 'http://localhost:8080/api/student/',
        'headers': {
          'content-type': 'application/json'
        }
      }).then(result => {
        this.student = result.data
      }, error => {
        console.error(error)
      })
    },
    updateData (id) {
      this.$router.push({ path: 'updateStudent/' + id })
    },
    deleteData (id) {
      this.studentDetail.studentId = id
      axios({
        method: 'POST',
        'url': 'http://localhost:8080/api/student/delete',
        'data': JSON.stringify(this.studentDetail),
        'headers': {
          'content-type': 'application/json'
        }
      }).then(result => {
        this.student = result.data
      }, error => {
        console.error(error)
      })
    }
  }
}
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
