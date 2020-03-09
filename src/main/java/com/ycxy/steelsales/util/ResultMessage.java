package com.ycxy.steelsales.util;

import java.io.Serializable;
import java.util.List;


public class ResultMessage implements Serializable {
 private Integer code;
 private String message;
 private Integer count;
 private List<?> data;

 public ResultMessage() {
 }

 public ResultMessage(Integer code, String message, Integer count, List<?> data) {
  this.code = code;
  this.message = message;
  this.count = count;
  this.data = data;
 }

 public Integer getCode() {
  return code;
 }

 public void setCode(Integer code) {
  this.code = code;
 }

 public String getMessage() {
  return message;
 }

 public void setMessage(String message) {
  this.message = message;
 }

 public Integer getCount() {
  return count;
 }

 public void setCount(Integer count) {
  this.count = count;
 }

 public List<?> getData() {
  return data;
 }

 public void setData(List<?> data) {
  this.data = data;
 }

 @Override
 public String toString() {
  return "ResultMessage{" +
          "code=" + code +
          ", message='" + message + '\'' +
          ", count=" + count +
          ", data=" + data +
          '}';
 }
}
