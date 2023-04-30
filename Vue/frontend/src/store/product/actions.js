import {
  REQUEST_PRODUCT_LIST_TO_SPRING,
  REQUEST_PRODUCT_TO_SPRING,
} from "./mutation-types";

import axiosInst from "@/utility/axiosInst";

export default {
  requestProductToSpring({ commit }, productId) {
    return axiosInst.get(`/product/${productId}`)
      .then((res) => {
        commit(REQUEST_PRODUCT_TO_SPRING, res.data)
      })
  },
  requestProductListoSpring({ commit }) {
    return axiosInst.get("/product/list").then((res) => {
      commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data);
    });
  },
  requestCreateProductToSpring({ }, payload) {
    const { name, price, company, manufactureDate, category } = payload;

    return axiosInst
      .post("/product/register", {
        name,
        price,
        company,
        manufactureDate,
        category,
      })
      .then((res) => {
        alert("상품 등록 성공!");
        return res;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
  requestDeleteProductToSpring({ }, productId) {
    return axiosInst
      .delete(`/jpa-product/${productId}`)
      .then((res) => {
        alert("삭제 성공!");
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },

  requestProductModifyToSpring ({}, payload) {
    const { name, price, company, manufactureDate, category,productId } = payload
    // 역시 payload는 우리가 보낼 데이터

    console.log("")

    return axiosInst.put(`/product/${productId}`, {  name, price, company, manufactureDate, category })
        .then((res) => {
            // axios.put은 수정을 하라는 요청이다. 해당 id의 데이터를 다시 보내는 payload로 수정해라
            alert("수정 성공!")
        })
        .catch(() => {
            alert('문제 발생!')
        })
},

  requestProductModifyToSpring({ }, payload) {
    const { name, price, company, manufactureDate, category, productId } = payload
    //역시 payload는 우리가 보낼 데이터를 뜻함

    console.log("")

    return axiosInst.put(`/product/${productId}`, { name, price, company, manufactureDate, category })
      .then((res) => {
        //axios.put은 수정을 하라는 요청이다. 해당 id의 데이터를 다시 보내는 payload로 수정해라!
        alert("수정 성공!")
      })
      .catch(() => {
        alert('문제 발생!')
      })
  },


}
