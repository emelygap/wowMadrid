from config import db

class Area(db.Model):
    __tablename__ = 'areas'
    
    id = db.Column(db.Integer, primary_key=True)
    street_address = db.Column(db.String, nullable=False)
    postal_code = db.Column(db.String(15), nullable=False)

    addresses = db.relationship("Address", backref='area_addresses', lazy='joined')
    
    def __repr__(self):
        return f"<Area(id={self.id}, street_address='{self.street_address}', postal_code='{self.postal_code}')>"
    

    def dict(self):
        return {
            'id': self.id,
            'street_address': self.street_address,
            'postal_code': self.postal_code
        }