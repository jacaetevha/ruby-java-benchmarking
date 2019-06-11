require 'benchmark'

module Enumerable
  def fold(accumulator)
    self.each { |element| accumulator = yield accumulator, element }
    accumulator
  end

  alias :fold_a :inject
end

n = ENV.fetch("COUNT", "1000").to_i
array_size = ENV.fetch("ARRAY_SIZE", "10000").to_i
a = (1..array_size).to_a

puts "COUNT: #{n}"
puts "ARRAY SIZE: #{array_size}\n\n"

Benchmark.bmbm do |x|
  x.report('inject') { n.times { a.inject(0) { |a, e| a + e } }}
  x.report('aliased fold') { n.times { a.fold_a(0) { |a, e| a + e } }}
  x.report('handcrafted fold') { n.times { a.fold(0) { |a, e| a + e } } }
end
