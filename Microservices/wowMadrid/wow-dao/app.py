from config import app
from api.event_api import event_route
from api.district_api import district_route
from flask_toolkits import AutoSwagger

auto_swagger = AutoSwagger(description='OpenApi documentation for WOW Madrid wowDAO microservice', title='wowDAO', version='1.0')

app.register_blueprint(event_route)
app.register_blueprint(district_route)
app.register_blueprint(auto_swagger)

if __name__ == '__main__':
   app.run(host='0.0.0.0', port=5000)