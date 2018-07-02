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
    public class TacGiasController : ApiController
    {
        private dbthayvuapi2 db = new dbthayvuapi2();

        // GET: api/TacGias
        public IQueryable<TacGia> GetTacGias()
        {
            return db.TacGias;
        }

        // GET: api/TacGias/5
        [ResponseType(typeof(TacGia))]
        public IHttpActionResult GetTacGia(string id)
        {
            TacGia tacGia = db.TacGias.Find(id);
            if (tacGia == null)
            {
                return NotFound();
            }

            return Ok(tacGia);
        }

        // PUT: api/TacGias/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTacGia(string id, TacGia tacGia)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != tacGia.IDTacGia)
            {
                return BadRequest();
            }

            db.Entry(tacGia).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TacGiaExists(id))
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

        // POST: api/TacGias
        [ResponseType(typeof(TacGia))]
        public IHttpActionResult PostTacGia(TacGia tacGia)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TacGias.Add(tacGia);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (TacGiaExists(tacGia.IDTacGia))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = tacGia.IDTacGia }, tacGia);
        }

        // DELETE: api/TacGias/5
        [ResponseType(typeof(TacGia))]
        public IHttpActionResult DeleteTacGia(string id)
        {
            TacGia tacGia = db.TacGias.Find(id);
            if (tacGia == null)
            {
                return NotFound();
            }

            db.TacGias.Remove(tacGia);
            db.SaveChanges();

            return Ok(tacGia);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TacGiaExists(string id)
        {
            return db.TacGias.Count(e => e.IDTacGia == id) > 0;
        }
    }
}