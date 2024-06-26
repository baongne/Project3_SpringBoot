/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.project3.controller;

import com.example.project3.models.ThanhVien;
import com.example.project3.models.ThietBi;
import com.example.project3.models.ThongTinSD;
import com.example.project3.models.XuLy;
import com.example.project3.repository.ThanhVienRepository;
import com.example.project3.repository.ThietBiRepository;
import com.example.project3.repository.ThongTinSDRepository;
import com.example.project3.repository.XuLyRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserHomeController {

    private final ThanhVienRepository thanhVienRepository;
    private final XuLyRepository xuLyRepository;
    private final ThongTinSDRepository thongTinSDRepository;
    private final ThietBiRepository thietBiRepository;

    @Autowired
    public UserHomeController(ThanhVienRepository thanhVienRepository, XuLyRepository xuLyRepository, ThongTinSDRepository thongTinSDRepository, ThietBiRepository thietBiRepository) {
        this.thanhVienRepository = thanhVienRepository;
        this.xuLyRepository = xuLyRepository;
        this.thongTinSDRepository = thongTinSDRepository;
        this.thietBiRepository = thietBiRepository;
    }

    @GetMapping("/user")
    public String homepage() {
        return "user/index";
    }

    @GetMapping("/userHoSo")
    public String hosopage(Model model, @RequestParam("maTV") String maTV) {
        // Lấy thông tin thành viên từ session
        Optional<ThanhVien> user = thanhVienRepository.findById(Integer.parseInt(maTV));
        ThanhVien tv = user.get();
        // Nếu tìm thấy, truyền thông tin thành viên qua model
        if (user != null) {
            model.addAttribute("thanhVien", tv);
        }

        return "user/hoso";
    }

    @GetMapping("/userTrangThaiVP")
    public String trangthaivppage(Model model, @RequestParam("maTV") String maTV) {
        ThanhVien tv = new ThanhVien();
        tv.setMaTV(Integer.parseInt(maTV));
        List<XuLy> user = xuLyRepository.findByThanhVien(tv);

        if (!user.isEmpty()) {
            XuLy xl = user.get(0);

            // Kiểm tra xem thuộc tính soTien có null không trước khi truy cập
            if (xl.getSoTien() != null) {
                model.addAttribute("xuLy", xl);
                return "user/xemtrangthaivp";
            } else {
                // Xử lý trường hợp soTien là null ở đây
                xl.setSoTien(0); // Đặt giá trị mặc định cho soTien
                model.addAttribute("xuLy", xl);
                return "user/xemtrangthaivp";
            }
        } else {
            return "user/khongcothongtin";
        }
    }

    @GetMapping("/userThietBiDangMuon")
    public String tbdangmuonpage(Model model, @RequestParam("maTV") String maTV) {
        // Tạo đối tượng ThanhVien và Thiết bị
        ThanhVien tv = new ThanhVien();
//        ThietBi tb = new ThietBi();
        tv.setMaTV(Integer.parseInt(maTV));
//        tb.getMaTB();

        // Tìm thông tin về việc sử dụng thiết bị của thành viên
        List<ThongTinSD> user = thongTinSDRepository.findByThanhVien(tv);

        // Tìm thông tin về việc thiết bị đã được sử dụng bởi thành viên
//        List<ThongTinSD> device = thongTinSDRepository.findByThietBi(tb);
        // Kiểm tra xem có thông tin sử dụng thiết bị của thành viên hay không
        if (!user.isEmpty()) {
            ThongTinSD ttsdUser = user.get(0);
            if (ttsdUser.getThietBi() != null) {
                // Thêm thông tin sử dụng thiết bị của thành viên vào model
                model.addAttribute("thongTin", ttsdUser);
            } else {
                return "user/khongcothongtin";
            }

        } else {
            // Trả về trang thông báo không có thông tin nếu không tìm thấy
            return "user/khongcothongtin";
        }
        return "user/xemthietbidangmuon";

//        // Kiểm tra xem có thông tin về thiết bị đã được sử dụng bởi thành viên hay không
//        if (!device.isEmpty()) {
//            ThongTinSD ttsdDevice = device.get(0);
//
//            // Thêm thông tin thiết bị đã được sử dụng bởi thành viên vào model
//            model.addAttribute("thongTinSDDevice", ttsdDevice);
//        } 
    }

    @GetMapping("/userDatChoThietBi")
    public String datchotbpage(Model model) {
        // Lấy danh sách tất cả các thiết bị từ cơ sở dữ liệu
        List<ThietBi> danhSachThietBi = thietBiRepository.findAll();

        // Truyền danh sách các thiết bị qua model
        model.addAttribute("thietBi", danhSachThietBi);

        return "user/xemdatchothietbi";
    }
}
   