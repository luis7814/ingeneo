import React, { useState } from 'react';

function ShippingForm() {
  const [formData, setFormData] = useState({
    productTypeId: '',
    quantityProduct: '',
    registrationDate: '',
    deliverDate: '',
    destinationId: '',
    priceShipping: '',
    vehicleNumber: '',
    clientId: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8089/shipping', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization' : 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvIiwiaWF0IjoxNzA4Mjc4MzQ2LCJleHAiOjE3MDgyODE5NDZ9.BYNxBeEmj9wpY8dHgf2NfcGZ1ZKYEuc8tl6imidJUnk'
        },
        body: JSON.stringify(formData),
      });
      if (!response.ok) throw new Error('Something went wrong');
      const data = await response.json();
      console.log(data);
      alert('Form submitted successfully!');
    } catch (error) {
      console.error('Error:', error);
      alert('Error submitting form');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="productTypeId">Product Type ID:</label>
        <input
          type="text"
          id="productTypeId"
          name="productTypeId"
          value={formData.productTypeId}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="quantityProduct">quantityProduct:</label>
        <input
          type="number"
          id="quantityProduct"
          name="quantityProduct"
          value={formData.quantityProduct}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="registrationDate">registrationDate:</label>
        <input
          type="date"
          id="registrationDate"
          name="registrationDate"
          value={formData.registrationDate}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="deliverDate">deliverDate:</label>
        <input
          type="date"
          id="deliverDate"
          name="deliverDate"
          value={formData.deliverDate}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="destinationId">destinationId ID:</label>
        <input
          type="text"
          id="destinationId"
          name="destinationId"
          value={formData.destinationId}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="priceShipping">priceShipping:</label>
        <input
          type="number"
          id="priceShipping"
          name="priceShipping"
          value={formData.priceShipping}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="vehicleNumber">vehicleNumber:</label>
        <input
          type="text"
          id="vehicleNumber"
          name="vehicleNumber"
          value={formData.vehicleNumber}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="clientId">clientId:</label>
        <input
          type="text"
          id="clientId"
          name="clientId"
          value={formData.clientId}
          onChange={handleChange}
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
}

export default ShippingForm;