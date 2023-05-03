# Pasos para guardar un paquete con información válida
Given(/^I have a package with id "(.*?)" and date "(.*?)" and content "(.*?)" and description "(.*?)" and loggerId (\d+) and storehouseId (\d+)$/) do |id, date, content, description, loggerId, storehouseId|
  @package_data = {id: id, date: date, content: content, description: description, loggerId: loggerId.to_i, storehouseId: storehouseId.to_i}
end

When(/^I save the package$/) do
  @result = PackageService.savePackage(@package_data[:id], @package_data[:date], @package_data[:content], @package_data[:description], @package_data[:loggerId], @package_data[:storehouseId])
end

Then(/^the package should be saved successfully$/) do
  expect(@result).to eq(0)
end

# Pasos para guardar un paquete con los campos vacíosGiven(/^I have a package with id "(.*?)" and date "(.*?)" and content "(.*?)" and description "(.*?)" and loggerId (\d+) and storehouseId (\d+)$/) do |id, date, content, description, loggerId, storehouseId|
  @package_data = {id: id, date: date, content: content, description: description, loggerId: loggerId.to_i, storehouseId: storehouseId.to_i}
end

Then(/^the package should not be saved$/) do
  expect(@result).to eq(1)
end

