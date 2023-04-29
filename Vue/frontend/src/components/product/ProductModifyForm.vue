<template lang="">
    <div>
       <form @submit.prevent="onSubmit">
           <table>
          <tr>
                <td>상품명</td>
                <td>
                    <input type="text" v-model="name" />   
                </td>
            </tr>
            <tr>
                <td>상품가격</td>
                <td>
                    <input type="text" v-model="price" />
                </td>
            </tr>
            <tr>
                <td>제조사</td>
                <td>
                    <input type="text" v-model="company" />
                </td>
            </tr>
            <tr>
                <td>제조일</td>
                <td>
                    <input type="text" v-model="manufactureDate" />
                </td>
            </tr>
            <tr>
                <td>상품카테고리</td>
                <td>
                    <input type="text" v-model="category" />
                </td>
            </tr>
       </table>
   <div>
       <button type="submit">수정 완료</button>
       <!--수정 취소를 하면 읽기 페이지로 가도록 설정함 수정한 boardId에 맞춰서
       읽히도록 한다.-->
       <router-link :to="{
           name:'ProductReadPage',
           params: {productId: product.productId.toString()}
       }">수정 취소</router-link>
   </div>
   </form>
   </div>
</template>
<script>
export default {
   props: {
       product: {
           type: Object,
           required: true,
           //required: true-꼭필요하다는 뜻
       }
   },
   data () {
       return {
           name: '',
           price: '',
           company: '',
           manufactureDate: '',
           category:''
       }
   },
   created () {
       this.name = this.product.name //스프링에서 id에 맞게 받아온 정보들을 보여주기 위함
       this.price = this.product.price
       this.company = this.product.company
       this.manufactureDate = this.product.manufactureDate
       this.category=this.product.category
   
   },
   methods: {
       onSubmit () {
           const { name, price, company, manufactureDate, category} = this
           this.$emit('submit', {  name, price, company, manufactureDate, category })
           //onSubmit을 통해 submit이 활성화됨으로 수정이 완료됨
       }
   }
}
</script>
<style lang="">
   
</style>