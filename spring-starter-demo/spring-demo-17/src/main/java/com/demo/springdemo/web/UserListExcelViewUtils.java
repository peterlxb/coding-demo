package com.demo.springdemo.web;

import com.demo.springdemo.domain.User;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class UserListExcelViewUtils {
  // 将数据导出成excel文件
  public static ResponseEntity<byte[]> exportUser2Excel(List<User> users) {
    HttpHeaders headers = null;
    ByteArrayOutputStream baos = null;
    try {
      //1.创建Excel文档
      HSSFWorkbook workbook = new HSSFWorkbook();
      //2.创建文档摘要
      workbook.createInformationProperties();

      //创建Excel表单
      HSSFSheet sheet = (HSSFSheet) workbook.createSheet("users");

      //创建日期显示格式
      HSSFCellStyle dateCellStyle = workbook.createCellStyle();
      dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

      //5.设置表头
      HSSFRow header = sheet.createRow(0);

      header.createCell(0).setCellValue("帐号");
      header.createCell(1).setCellValue("姓名");
      header.createCell(2).setCellValue("生日");

      // 往表格里面插入数据
      int rowNum = 1;
      for (User user : users) {
        HSSFRow row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(user.getUserName());
        row.createCell(1).setCellValue(user.getRealName());
        String createDate = DateFormatUtils.format(user.getBirthday(),
          "yyyy-MM-dd");
        row.createCell(2).setCellValue(createDate);
      }

      headers = new HttpHeaders();
      headers.setContentDispositionFormData("attachment",
        new String("人员信息表.xls".getBytes("UTF-8"), "iso-8859-1"));
      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      baos = new ByteArrayOutputStream();
      workbook.write(baos);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
  }
}
