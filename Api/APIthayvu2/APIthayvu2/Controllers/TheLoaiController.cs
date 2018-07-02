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
    public class TheLoaiController : ApiController
    {
        private dbthayvuapi2 db = new dbthayvuapi2();

        // GET: api/TheLoai
        public IQueryable<TheLoai> GetTheLoais()
        {
            return db.TheLoais;
        }

        // GET: api/TheLoai/5
        [ResponseType(typeof(TheLoai))]
        public IHttpActionResult GetTheLoai(string id)
        {
            TheLoai theLoai = db.TheLoais.Find(id);
            if (theLoai == null)
            {
                return NotFound();
            }

            return Ok(theLoai);
        }

        // PUT: api/TheLoai/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTheLoai(string id, TheLoai theLoai)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != theLoai.IDTheLoai)
            {
                return BadRequest();
            }

            db.Entry(theLoai).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TheLoaiExists(id))
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

        // POST: api/TheLoai
        [ResponseType(typeof(TheLoai))]
        public IHttpActionResult PostTheLoai(TheLoai theLoai)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TheLoais.Add(theLoai);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (TheLoaiExists(theLoai.IDTheLoai))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = theLoai.IDTheLoai }, theLoai);
        }

        // DELETE: api/TheLoai/5
        [ResponseType(typeof(TheLoai))]
        public IHttpActionResult DeleteTheLoai(string id)
        {
            TheLoai theLoai = db.TheLoais.Find(id);
            if (theLoai == null)
            {
                return NotFound();
            }

            db.TheLoais.Remove(theLoai);
            db.SaveChanges();

            return Ok(theLoai);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TheLoaiExists(string id)
        {
            return db.TheLoais.Count(e => e.IDTheLoai == id) > 0;
        }
    }
}