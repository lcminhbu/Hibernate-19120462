create database DeAn
use DeAn
alter user 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY '123456';
create table giaoVu
(
	maGiaoVu char(8),
    hoTen VARCHAR(50) CHARSET utf8mb4,
    diaChi VARCHAR(100) CHARSET utf8mb4,
    gioi VARCHAR(3) CHARSET utf8mb4,
    ngaySinh datetime,
    primary key(maGiaoVu)
)

create table taiKhoanGiaoVu
(
	maGiaoVu char(8),
    tk char(20),
    mk char(20),
    primary key(maGiaoVu)
)

create table sinhVien
(
	maSinhVien char(8),
    hoTen VARCHAR(50) CHARSET utf8mb4,
    diaChi VARCHAR(100) CHARSET utf8mb4,
    ngaySinh datetime,
    gioi VARCHAR(3) CHARSET utf8mb4,
    khoaHoc varchar(10),
    cmnd char(12),
    primary key(maSinhVien, cmnd)
)

create table taiKhoanSinhVien
(
	maSinhVien char(8),
    cmnd char(12),
    tk char(20),
    mk char(20),
    primary key(cmnd)
)

create table hocPhan
(
	maHocPhan char(10),
	hocKi char(3),
    namHoc varchar(10),
    tenHocPhan VARCHAR(50) CHARSET utf8mb4,
    soSlotToiDa int,
    ngayHoc VARCHAR(10) CHARSET utf8mb4,
    caHoc char(11),
    phongHoc VARCHAR(20) CHARSET utf8mb4,
    soTC int,
    giaoVienLyThuyet char(8),
    primary key(maHocPhan, hocKi, namHoc)
)

create table kyDKHP
(
    batDau datetime,
    ketThuc datetime,
    hocKi char(3),
    namHoc varchar(10),
    primary key (batDau, hocKi, namHoc)
)

create table hocKi
(
	tenHocKi char(3),
	namHoc varchar(10),
	ngayBatDau datetime,
    ngayKetThuc datetime,
	hocKiHienTai bool,
    primary key (tenHocKi, namHoc)
)

create table lop
(
	soSV int,
    soSVNu int,
    soSVNam int,
    tenLop VARCHAR(50) CHARSET utf8mb4,
    maLop char(8),
    hocKi char(3),
    namHoc varchar(10),
    primary key(maLop, hocKi, namHoc)
)

create table sinhVien_Lop
(
	maSinhVien char(8),
    cmnd char(12),
    maLop char(8),
    hocKi char(3),
    namHoc varchar(10),
    primary key(cmnd, maLop, hocKi, namHoc)
)

create table dangKyHocPhan
(
	maSinhVien char(8),
    cmnd char(12),
    maHocPhan char(10),
    hocKi char(3),
    namHoc varchar(10),
    thoiGianDangKi datetime,
    primary key (cmnd, maHocPhan, hocKi, namHoc)
)

alter table taiKhoanGiaoVu
add constraint fk_taikhoan_gv
foreign key (maGiaoVu)
references giaoVu(maGiaoVu)

alter table taiKhoanSinhVien
add constraint fk_taikhoan_sv
foreign key (maSinhVien, cmnd)
references sinhVien(maSinhVien, cmnd)

alter table hocPhan
add constraint fk_hp_hocki
foreign key (hocKi, namHoc)
references hocKi(tenHocKi, namHoc)

alter table kyDKHP
add constraint fk_dk_hk
foreign key (hocKi, namHoc)
references hocKi(tenHocKi, namHoc)

alter table lop
add constraint fk_lop_hocki
foreign key (hocKi, namHoc)
references hocKi(tenHocKi, namHoc)

alter table sinhVien_Lop
add constraint fk_svlop_sv
foreign key (maSinhVien, cmnd)
references sinhVien(maSinhVien, cmnd)

alter table sinhvien_lop
add constraint fk_svlop_lop
foreign key (maLop, hocKi, namHoc)
references lop(maLop, hocKi, namHoc)

alter table dangKyHocPhan
add constraint fk_dkhp_sv
foreign key (maSinhVien, cmnd)
references sinhVien(maSinhVien, cmnd)

alter table dangKyHocPhan
add constraint fk_dkhp_hp
foreign key (maHocPhan, hocKi, namHoc)
references hocPhan(maHocPhan, hocKi, namHoc)

alter table giaoVu
add constraint c_gioi_gv 
check(gioi in ('Nam', 'Nữ'))

alter table sinhVien
add constraint c_gioi_sv
check(gioi in ('Nam', 'Nữ'))

alter table hocPhan
add constraint c_ngay_hp
check(ngayHoc in ('Thứ hai', 'Thứ ba', 'Thứ tư', 'Thứ năm', 'Thứ sáu', 'Thứ bảy', 'Chủ nhật'))

alter table hocPhan
add constraint c_ca_hp
check(caHoc in ('07:30-09:30', '09:30-11:30', '13:30-15:30', '15:30-17:30'))

alter table hocPhan
add constraint c_tc_hp
check(soTC>0)

alter table hocKi
add constraint c_ten_hk
check(tenHocKi in ('HK1', 'HK2', 'HK3'))

insert into giaoVu values ('00000001', 'Nguyễn Văn Chữ', 'Nguyễn Văn Bảo, Phường 4, Gò Vấp, TPHCM', 'Nam', '1996-02-19')
insert into giaoVu values ('00000002', 'Trần Thị An', '58 Phạm Viết Chánh, P.Nguyễn Cư Trinh, Quận 1, TPHCM', 'Nữ', '1970-10-20')
insert into giaoVu values ('00000003', 'Trần Văn Chiến', '60 Phạm Viết Chánh, P.Nguyễn Cư Trinh, Quận 1, TPHCM', 'Nam', '1960-7-10')

insert into taiKhoanGiaoVu values ('00000001', 'giaovu1', 'giaovu1')
insert into taiKhoanGiaoVu values ('00000002', 'giaovu2', 'giaovu2')
insert into taiKhoanGiaoVu values ('00000003', 'giaovu3', 'giaovu3')

insert into sinhVien values ('19120001', 'Trần Thị Bạch', 'Gò Vấp, TPHCM', '2001-2-20', 'Nữ', 'K2019', '123456789123')
insert into sinhVien values ('19120201', 'Trần Văn Thắng', '57 Lê Lai, Da Kao, Quận 1, TPHCM', '2000-5-17', 'Nam', 'K2018', '281749276201')
insert into sinhVien values ('19120269', 'Nguyễn Thị Kiều Trinh', '62 Nguyễn Trãi, Phường 01, Quận 5, TPHCM', '2001-6-10', 'Nam', 'K2018', '472836291758')

insert into taiKhoanSinhVien values ('19120001','123456789123', 'sv2', 'sv2')
insert into taiKhoanSinhVien values ('19120201','281749276201', 'sv1', 'sv1')
insert into taiKhoanSinhVien values ('19120269','472836291758', 'sv3', 'sv3')

insert into hocKi values ('hk1', '2019-2020', '2019-8-10', '2020-2-14', false)
insert into hocKi values ('hk2', '2019-2020', '2020-3-1', '2020-6-15', false)
insert into hocKi values ('hk1', '2020-2021', '2020-9-1', '2021-3-10', false)
insert into hocKi values ('hk2', '2020-2021', '2021-3-20', '2021-7-15', true)

insert into hocPhan values ('0000000001', 'hk2', '2019-2020', 'Toán tổ hợp', 120, 'thứ hai', '07:30-09:30', 'E302', 1, '00000002')
insert into hocPhan values ('0000000001', 'hk1', '2019-2020', 'Toán rời rạc', 130, 'thứ ba', '07:30-09:30', 'E302', 1, '00000002')
insert into hocPhan values ('0000000001', 'hk2', '2020-2021', 'LTUD Java', 120, 'thứ năm', '09:30-11:30', 'E302', 1, '00000006')

insert into kyDKHP values ('2021-02-12 7:20:50', '2021-02-23 9:00:01', 'hk1', '2019-2020')
insert into kyDKHP values ('2021-02-12 7:20:50', '2021-02-23 9:00:01', 'hk2', '2019-2020')
insert into kyDKHP values ('2021-02-12 7:20:50', '2021-02-23 9:00:01', 'hk1', '2020-2021')

insert into lop values (120, (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nữ'), (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nam'), 'Toán', '12412412', 'hk1', '2019-2020')
insert into lop values (100, (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nữ'), (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nam'), 'Toán', '12412412', 'hk2', '2019-2020')
insert into lop values (100, (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nữ'), (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nam'), 'Toán', '12412412', 'hk1', '2020-2021')

insert into sinhVien_Lop values ('19120001','123456789123', '12412412', 'hk1', '2019-2020')
insert into sinhVien_Lop values ('19120201','281749276201', '12412412', 'hk1', '2019-2020')
insert into sinhVien_Lop values ('19120269','472836291758', '12412412', 'hk1', '2019-2020')

insert into dangKyHocPhan values ('19120001','123456789123', '0000000001', 'hk2', '2019-2020', null)
insert into dangKyHocPhan values ('19120001','123456789123', '0000000001', 'hk1', '2019-2020', null)
insert into dangKyHocPhan values ('19120201','281749276201', '0000000001', 'hk2', '2020-2021', null)