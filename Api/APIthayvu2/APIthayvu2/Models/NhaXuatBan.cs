namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("NhaXuatBan")]
    public partial class NhaXuatBan
    {
        [Key]
        [StringLength(5)]
        public string IDNhaXuatBan { get; set; }

        [StringLength(50)]
        public string TenNhaXuatBan { get; set; }
    }
}
