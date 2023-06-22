FROM python:3.10-alpine3.18

EXPOSE 5000

WORKDIR /app

COPY . .

RUN pip install -r requirements.txt

CMD ["python3", "app.py"]