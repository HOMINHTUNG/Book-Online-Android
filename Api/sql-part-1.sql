Create database QLTVienthayvuver4
go
Use QLTVienthayvuver4
go

Create table [Sach] (
	[IDSach] Char(5) NOT NULL,
	[IDTheLoai] Char(5) NOT NULL,
	[IDTacGia] Char(5) NULL,
	[IDNhaXuatBan] Char(5) NULL,
	[TenSach] NVarchar(50) NOT NULL,
	[HinhAnh] Varchar(200) NULL,
	[NamXuatBan] Integer NULL,
	[SoLuong] Integer DEFAULT 0,
	[SoLuongTon] Integer DEFAULT 0,
	[TriGia] Decimal(9,0) DEFAULT 0,
	[SoLanMuon] Integer DEFAULT 0,
	[NgayNhapSach] Datetime NULL,
	[MoTa] NVarchar(MAX) NULL,
Primary Key  ([IDSach])
)
go

Create table [NhaXuatBan] (
	[IDNhaXuatBan] Char(5) NOT NULL,
	[TenNhaXuatBan] NVarchar(50) NULL,
Primary Key  ([IDNhaXuatBan])
) 
go

Create table [TacGia] (
	[IDTacGia] Char(5) NOT NULL,
	[TenTacGia] NVarchar(50) NULL,
Primary Key  ([IDTacGia])
) 
go

Create table [TheLoai] (
	[IDTheLoai] Char(5) NOT NULL,
	[TenTheLoai] NVarchar(50) NULL,
Primary Key  ([IDTheLoai])
) 
go

Create table [ChiTietPhieuNhapSach] (
	[IDPhieuNhapSach] Char(5) NOT NULL,
	[IDSach] Char(5) NOT NULL,
	[SoLuong] Integer DEFAULT 0,
	[DonGia] Decimal(9,0) DEFAULT 0,
Primary Key  ([IDPhieuNhapSach],[IDSach])
) 
go

Create table [PhieuNhapSach] (
	[IDPhieuNhapSach] Char(5) NOT NULL,
	[IDNhanVien] Char(5) NULL,
	[NgayNhap] Datetime NULL,
	[TongSoLuong] Integer DEFAULT 0,
	[TongDongia] Decimal(9,0) DEFAULT 0,
Primary Key  ([IDPhieuNhapSach])
) 
go

Create table [NhanVien] (
	[IDNhanVien] Char(5) NOT NULL,
	[IDChucVu] Char(5) NOT NULL,
	[TenNhanVien] NVarchar(50) NULL,
	[GioiTinh] Integer NULL,
	[DiaChi] NVarchar(100) NULL,
	[SoDienThoai] Char(12) NULL,
	[Email] Varchar(50) NULL,
	[CMND] Char(11) NULL,
	[NgayVaoLam] Date NULL,
	[MatKhau] Varchar(100) NULL,
Primary Key  ([IDNhanVien])
) 
go

Create table [BangRangBuoc] (
	[IDRangBuoc] Char(5) NOT NULL,
	[GiaTri] Integer NULL,
	[NgayHieuLuc] Date NULL,
	[GhiChu] NVarchar(100) NULL,
Primary Key  ([IDRangBuoc])
) 
go

Create table [DocGia] (
	[IDDocGia] Char(5) NOT NULL,
	[SoDienThoai] Varchar(11) NOT NULL,
	[MatKhau] Varchar(100) NOT NULL,
	[TenDocGia] NVarchar(50) NOT NULL,
	[DiaChi] NVarchar(100) NULL,
	[Email] Varchar(50) NOT NULL,
	[CMND] Char(11) NOT NULL,
	[NgayLap] Date NULL,
	[NgayHetHan] Date NULL,
	[NgaySinh] Date NULL,
	[TinhTrang] Integer NULL,
	[TongTienPhat] Decimal(9,0) DEFAULT 0,
Primary Key  ([IDDocGia])
) 
go

Create table [CTMuonTra] (
	[STT] Char(5) NOT NULL,
	[IDSach] Char(5) NOT NULL,
	[IDDocGia] Char(5) NOT NULL,
	[NgayMuon] Datetime NULL,
	[NgayTraQuyDinh] Datetime NULL,
	[NgayTraThucTe] Datetime NULL,
	[NgayQuaHan] Integer DEFAULT 0,
	[TinhTrangMuon] Integer DEFAULT 0,
	[SoLuongThue] Integer DEFAULT 0,
	[TriGia] Decimal(9,0) DEFAULT 0,
	[TienCoc] Decimal(9,0) DEFAULT 0,
	[TienThue] Decimal(9,0) DEFAULT 0,
	[TienPhat] Decimal(9,0) DEFAULT 0,
	[TongTien] Decimal(9,0) DEFAULT 0,
Primary Key  ([STT],[IDSach],[IDDocGia])
) 
go

Create table [ChucVu] (
	[IDChucVu] Char(5) NOT NULL,
	[TenChucVu] NVarchar(20) NULL,
Primary Key  ([IDChucVu])
) 
go

Create table [PhieuThuTienPhat] (
	[IDPhieuThuTienPhat] Char(5) NOT NULL,
	[IDDocGia] Char(5) NOT NULL,
	[NgayThang] Date NULL,
	[TienThu] Decimal(9,0) DEFAULT 0,
Primary Key  ([IDPhieuThuTienPhat])
)
go


Alter table [ChiTietPhieuNhapSach] add  foreign key([IDSach]) references [Sach] ([IDSach]) 
go
Alter table [CTMuonTra] add  foreign key([IDSach]) references [Sach] ([IDSach]) 
go
Alter table [Sach] add  foreign key([IDNhaXuatBan]) references [NhaXuatBan] ([IDNhaXuatBan]) 
go
Alter table [Sach] add  foreign key([IDTacGia]) references [TacGia] ([IDTacGia]) 
go
Alter table [Sach] add  foreign key([IDTheLoai]) references [TheLoai] ([IDTheLoai]) 
go
Alter table [ChiTietPhieuNhapSach] add  foreign key([IDPhieuNhapSach]) references [PhieuNhapSach] ([IDPhieuNhapSach]) 
go
Alter table [CTMuonTra] add  foreign key([IDDocGia]) references [DocGia] ([IDDocGia]) 
go
Alter table [PhieuThuTienPhat] add  foreign key([IDDocGia]) references [DocGia] ([IDDocGia]) 
go
Alter table [NhanVien] add  foreign key([IDChucVu]) references [ChucVu] ([IDChucVu]) 
go
