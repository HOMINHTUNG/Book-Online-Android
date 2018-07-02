using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using APIthayvu2.Models;

namespace APIthayvu2.Controllers
{
    public class DocGiasController : ApiController
    {
        private dbthayvuapi2 db = new dbthayvuapi2();

        [ResponseType(typeof(DocGia))]
        [Route("api/DocGia/getKetQuaDangKy/{sodienthoai}/{email}")]
        public String getKetQuaDangKy(string sodienthoai, string email)
        {
            var a = db.DocGias.FirstOrDefault(n => n.Email.Equals(email));
            if (a != null)
            {
                return "Email đã tồn tại!";
            }
            else
            {
                var b = db.DocGias.FirstOrDefault(n => n.SoDienThoai.Equals(sodienthoai));
                if (b != null)
                {
                    return "Số điện thoại đã tồn tại!";
                }
            }

            return "true";  // không cho phép đăng kí

        }
        [ResponseType(typeof(DocGia))]
        [Route("api/DocGia/getDangNhap/{sodienthoai}/{matkhau}")]
        public DocGia getDangNhap(string sodienthoai, string matkhau)
        {
            DocGia user = db.DocGias.FirstOrDefault(n => n.SoDienThoai.Equals(sodienthoai) && n.MatKhau.Equals(matkhau));
            return user; 
        }
        [ResponseType(typeof(DocGia))]
        [Route("api/DocGia/getDocGia/{sodienthoai}/{matkhau}")]
        public DocGia getDocGia(string sodienthoai, string matkhau)
        {
            DocGia user = db.DocGias.FirstOrDefault(n => n.SoDienThoai.Equals(sodienthoai) && n.MatKhau.Equals(matkhau));
            return user; // lấy thông tin đọc giả đăng nhập
        }
        [ResponseType(typeof(DocGia))]
        [Route("api/DocGia/getKetQuaDoiMatKhau/{iddocgia}/{matkhaumoi}")]
        public int getKetQuaDoiMatKhau(string iddocgia, string matkhaumoi)
        {
            var a = db.DocGias.FirstOrDefault(n => n.IDDocGia.Equals(iddocgia));
            if (a.MatKhau != matkhaumoi)
            {
                return 1; //Cho phép đổi mật khẩu
            }
            return 0; //không cho phép đổi mật khẩu
        }

        // GET: api/DocGias
        public IQueryable<DocGia> GetDocGias()
        {
            return db.DocGias;
        }

        // GET: api/DocGias/5
        [ResponseType(typeof(DocGia))]
        public IHttpActionResult GetDocGia(string id)
        {
            DocGia docGia = db.DocGias.Find(id);
            if (docGia == null)
            {
                return NotFound();
            }

            return Ok(docGia);
        }

        // PUT: api/DocGias/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDocGia(string id, DocGia docGia)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != docGia.IDDocGia)
            {
                return BadRequest();
            }

            db.Entry(docGia).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DocGiaExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/DocGias
        [ResponseType(typeof(DocGia))]
        public IHttpActionResult PostDocGia(DocGia docGia)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.DocGias.Add(docGia);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (DocGiaExists(docGia.IDDocGia))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = docGia.IDDocGia }, docGia);
        }

        // DELETE: api/DocGias/5
        [ResponseType(typeof(DocGia))]
        public IHttpActionResult DeleteDocGia(string id)
        {
            DocGia docGia = db.DocGias.Find(id);
            if (docGia == null)
            {
                return NotFound();
            }

            db.DocGias.Remove(docGia);
            db.SaveChanges();

            return Ok(docGia);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DocGiaExists(string id)
        {
            return db.DocGias.Count(e => e.IDDocGia == id) > 0;
        }
    }
}