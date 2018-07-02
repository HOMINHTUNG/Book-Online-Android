namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("PhieuNhapSach")]
    public partial class PhieuNhapSach
    {
        [Key]
        [StringLength(5)]
        public string IDPhieuNhapSach { get; set; }

        [StringLength(5)]
        public string IDNhanVien { get; set; }

        public DateTime? NgayNhap { get; set; }

        public int? TongSoLuong { get; set; }

        public decimal? TongDongia { get; set; }
    }
}
