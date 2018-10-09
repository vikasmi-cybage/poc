<template>
  <div id='addStudent' style="margin-left: 493px;margin-top: 21px;">
    <h1>{{msg}}</h1> <span>  <router-link to="/addStudent"> Add Student </router-link> </span>
      <div class="row">
          <div class= "row col-sm-12">
                  <div class= "row col-sm-6">First Name</div>
                  <div class= "row col-sm-6"> <input type="text" v-model="studentDetail.firstName" name="firstName"></div>
          </div>
            <div class= "row col-sm-12">
                  <div class= "row col-sm-6">Midde Name</div>
                  <div class= "row col-sm-6"> <input type="text" v-model="studentDetail.middleName" name="middleName"></div>
          </div>
            <div class= "row col-sm-12">
                  <div class= "row col-sm-6">Last Name</div>
                  <div class= "row col-sm-6"> <input type="text" v-model="studentDetail.lastName" name="lastName"></div>
          </div>
           <div class= "row col-sm-12">
                  <div class= "row col-sm-6">Father Name</div>
                  <div class= "row col-sm-6"> <input type="text" v-model="studentDetail.fatherName" name="fatherName"></div>
          </div>
            <div class= "row col-sm-12">
                  <div class= "row col-sm-6">age</div>
                  <div class= "row col-sm-6"> <input type="text" v-model="studentDetail.age" name="age"></div>
          </div>
           <div class= "row col-sm-12">
                  <div></div>
                  <div >  <button  type="button" v-on:click.prevent="updateData" class="btn btn-success align-middle"> submit</button> </div>
          </div>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'addStudent',
  data () {
    return {
      msg: 'Please Add student',
      studentDetail: {
        firstName: '',
        lastName: '',
        fatherName: '',
        middleName: '',
        age: ''
      }
    }
  },
  methods: {
    updateData () {
      console.log(JSON.stringify(this.studentDetail))
      axios({
        method: 'POST',
        'url': 'http://localhost:8080/api/student/create',
        'data': JSON.stringify(this.studentDetail),
        'headers': {
          'content-type': 'application/json'
        }
      }).then(result => {
        this.response = result.data
      }, error => {
        console.error(error)
      })
      this.$router.push({ path: 'studentList' })
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
