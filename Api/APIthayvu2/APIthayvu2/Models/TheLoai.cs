namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("TheLoai")]
    public partial class TheLoai
    {
        [Key]
        [StringLength(5)]
        public string IDTheLoai { get; set; }

        [StringLength(50)]
        public string TenTheLoai { get; set; }
    }
}
