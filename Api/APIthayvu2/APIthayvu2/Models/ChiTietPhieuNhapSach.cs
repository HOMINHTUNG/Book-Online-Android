namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ChiTietPhieuNhapSach")]
    public partial class ChiTietPhieuNhapSach
    {
        [Key]
        [Column(Order = 0)]
        [StringLength(5)]
        public string IDPhieuNhapSach { get; set; }

        [Key]
        [Column(Order = 1)]
        [StringLength(5)]
        public string IDSach { get; set; }

        public int? SoLuong { get; set; }

        public decimal? DonGia { get; set; }
    }
}
