<template lang="">
    <div>
        <v-btn color = "red" @click = "readyToCreateProduct"> 제품 등록 버튼</v-btn>
        <br>
        <div v-if = "isPressedButton">
            <br>
        <form @submit.prevent="onSubmit">
        
            <table>
                <tr>
                    <td>상품 명</td>
                    <td>
                        <input type="text" v-model = "name">
                    </td>
                </tr>
                
                <tr>
                    <td>상품 가격</td>
                    <td>
                        <input type="text" v-model = "price">
                    </td>
                </tr>

                <tr>
                    <td>제조사</td>
                    <td>
                        <input type="text" v-model = "company">
                    </td>
                </tr>

                <tr>
                    <td>제조일</td>
                    <td>
                        <input type="text" v-model = "manufactureDate">
                    </td>
                </tr>

                <tr>
                    <td>상품 종류</td>
                    <td>
                        <input type="text" v-model = "category">
                    </td>
                </tr>
            </table>
            <br>

            <div>
                <button type="submit">상품 등록</button><br>
                
                <router-link :to="{ name: 'ProductListPage' }">
                돌아가기
                </router-link>

            </div>
        </form>

        </div>

    </div>
</template>
<script>

export default {
    name: "ProductRegisterForm",
    data() {
        return {
            name: '상품명',
            price: '상품 가격',
            company: '제조사',
            manufactureDate: '제조일',
            category: '상품 종류',
            isPressedButton: false,
        }
    },
    methods: {
        readyToCreateProduct() {
            this.isPressedButton = true
            alert('제품 등록 준비')
        },
        onSubmit() {
            const { name, price, company, manufactureDate, category } = this
            this.$emit('submit', { name, price, company, manufactureDate, category })


        }


    },

}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gothic+A1:wght@500&display=swap');

table {
    border: 4px solid mediumpurple;
    font-family: 'Gothic A1';
    font-size: 20px;
    margin: 10px;
}

td {
    border: 2px solid lightskyblue;
}
</style>