namespace APIthayvu2.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class dbthayvuapi2 : DbContext
    {
        public dbthayvuapi2()
            : base("name=dbthayvuapi2")
        {
        }

        public virtual DbSet<BangRangBuoc> BangRangBuocs { get; set; }
        public virtual DbSet<ChiTietPhieuNhapSach> ChiTietPhieuNhapSaches { get; set; }
        public virtual DbSet<ChucVu> ChucVus { get; set; }
        public virtual DbSet<CTMuonTra> CTMuonTras { get; set; }
        public virtual DbSet<DocGia> DocGias { get; set; }
        public virtual DbSet<NhanVien> NhanViens { get; set; }
        public virtual DbSet<NhaXuatBan> NhaXuatBans { get; set; }
        public virtual DbSet<PhieuNhapSach> PhieuNhapSaches { get; set; }
        public virtual DbSet<PhieuThuTienPhat> PhieuThuTienPhats { get; set; }
        public virtual DbSet<Sach> Saches { get; set; }
        public virtual DbSet<TacGia> TacGias { get; set; }
        public virtual DbSet<TheLoai> TheLoais { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<BangRangBuoc>()
                .Property(e => e.IDRangBuoc)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<ChiTietPhieuNhapSach>()
                .Property(e => e.IDPhieuNhapSach)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<ChiTietPhieuNhapSach>()
                .Property(e => e.IDSach)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<ChiTietPhieuNhapSach>()
                .Property(e => e.DonGia)
                .HasPrecision(9, 0);

            modelBuilder.Entity<ChucVu>()
                .Property(e => e.IDChucVu)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.STT)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.IDSach)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.IDDocGia)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.TriGia)
                .HasPrecision(9, 0);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.TienCoc)
                .HasPrecision(9, 0);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.TienThue)
                .HasPrecision(9, 0);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.TienPhat)
                .HasPrecision(9, 0);

            modelBuilder.Entity<CTMuonTra>()
                .Property(e => e.TongTien)
                .HasPrecision(9, 0);

            modelBuilder.Entity<DocGia>()
                .Property(e => e.IDDocGia)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<DocGia>()
                .Property(e => e.SoDienThoai)
                .IsUnicode(false);

            modelBuilder.Entity<DocGia>()
                .Property(e => e.MatKhau)
                .IsUnicode(false);

            modelBuilder.Entity<DocGia>()
                .Property(e => e.Email)
                .IsUnicode(false);

            modelBuilder.Entity<DocGia>()
                .Property(e => e.CMND)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<DocGia>()
                .Property(e => e.TongTienPhat)
                .HasPrecision(9, 0);

            modelBuilder.Entity<NhanVien>()
                .Property(e => e.IDNhanVien)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<NhanVien>()
                .Property(e => e.IDChucVu)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<NhanVien>()
                .Property(e => e.SoDienThoai)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<NhanVien>()
                .Property(e => e.Email)
                .IsUnicode(false);

            modelBuilder.Entity<NhanVien>()
                .Property(e => e.CMND)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<NhanVien>()
                .Property(e => e.MatKhau)
                .IsUnicode(false);

            modelBuilder.Entity<NhaXuatBan>()
                .Property(e => e.IDNhaXuatBan)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<PhieuNhapSach>()
                .Property(e => e.IDPhieuNhapSach)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<PhieuNhapSach>()
                .Property(e => e.IDNhanVien)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<PhieuNhapSach>()
                .Property(e => e.TongDongia)
                .HasPrecision(9, 0);

            modelBuilder.Entity<PhieuThuTienPhat>()
                .Property(e => e.IDPhieuThuTienPhat)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<PhieuThuTienPhat>()
                .Property(e => e.IDDocGia)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<PhieuThuTienPhat>()
                .Property(e => e.TienThu)
                .HasPrecision(9, 0);

            modelBuilder.Entity<Sach>()
                .Property(e => e.IDSach)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<Sach>()
                .Property(e => e.IDTheLoai)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<Sach>()
                .Property(e => e.IDTacGia)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<Sach>()
                .Property(e => e.IDNhaXuatBan)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<Sach>()
                .Property(e => e.HinhAnh)
                .IsUnicode(false);

            modelBuilder.Entity<Sach>()
                .Property(e => e.TriGia)
                .HasPrecision(9, 0);

            modelBuilder.Entity<TacGia>()
                .Property(e => e.IDTacGia)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<TheLoai>()
                .Property(e => e.IDTheLoai)
                .IsFixedLength()
                .IsUnicode(false);
        }
    }
}
